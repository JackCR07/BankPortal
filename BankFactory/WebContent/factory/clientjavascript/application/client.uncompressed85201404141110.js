/* Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright IBM Corp. 2011,2012,2013
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory (product id 5724-O03) product license for terms and conditions of use
 *
 * PRODUCT CODE: Not customer modifiable.  Changes will be overwritten on upgrade.
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.WebAppAccess85201404141110", null, {
    pages: {},
    dojoParser: null,
    executeScripts: false,
    instanceID: null,
    serviceErrorEvent: null,
    pageErrorEvent: null,
    currentPage: null,
    variables: {},
    enableDebugLog: false,
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
        this.pages = {};
        this.variables = {};
        dojo.safeMixin(this, args);
        var access = this;
        dojo.forEach(this.pages.getPages(), function(pageInfo) {
            pageInfo.template = access.initializeTemplate(pageInfo);
        });
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    initializeTemplate: function(pageInfo)
    {
        if (pageInfo == undefined || pageInfo.remote)
            return null;
        var template = null;
        var targetPage = this.getTargetPage(pageInfo);
        if (targetPage != undefined)
        {
            if (targetPage.nodeName == "SCRIPT" && (targetPage.type) && (targetPage.type === "text/plain"))
            {
                template = targetPage.textContent;
                if (template == undefined)
                    template = targetPage.text;
                template = template.replace(/wef.hide.script/g, "script");
                template = template.replace(/&#39;/g, "'");
                var placeholder = document.createElement('div');
                var attributes = targetPage.attributes;
                dojo.forEach(attributes, function(attr) {
                    placeholder.setAttribute(attr.name, attr.value);
                });
                placeholder.setAttribute("id", targetPage.getAttribute("id"));
                targetPage.parentNode.insertBefore(placeholder, targetPage);
                dojo.destroy(targetPage);
            }
            else
            {
            	console.error("Script element not found in initializeTemplate()");
            }
        }
        return template;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    destroyWidgets: function(page)
    {
        if (this.dojoParser != null)
        {
            if (this.enableDebugLog) this.log("destroyWidgets" + dojo.byId(page) + " on page " + page);
            try
            {
                var node = dojo.byId(page);
                var widgets = node ? dijit.findWidgets(node) : null;
                var access = this;
                while (widgets && widgets.length > 0)
                {
                    dojo.forEach(widgets, function(widget) {
                        if (widget != undefined)
                        {
                            if (access.enableDebugLog)
                            	access.log("about to destroy " + widget.id + " on page " + page);
                            widget.destroyRecursive(true);
                        }
                    });
                    widgets = dijit.findWidgets(node);
                }
                var w = dijit.byId(page);
                if (w)
                	w.destroy();
           }
           catch(ex)
           {
                console.error("Error in  destroyWidgets " + ex);
           }
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    parseWidgets: function(page)
    {
        if (this.dojoParser != null)
        {
            if (this.enableDebugLog)
            	this.log("parseWidgets on page " + page);
            var nodes = page.getElementsByTagName("*");
            var list = [];
            page._type = page.getAttribute("dojoType") || page.getAttribute("data-dojo-type");
		    if (page._type)
                list.push(page);
            for (var i = 0, len = nodes.length; i < len; i++)
            {
                nodes[i]._type = nodes[i].getAttribute("dojoType") || nodes[i].getAttribute("data-dojo-type");
                if (nodes[i]._type)
                {
                    list.push(nodes[i]);
                }
            }
            this.dojoParser.instantiate(list);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hidePages: function()
    {
        dojo.forEach(this.pages.pages, function(pageInfo) {
            var page = dojo.byId(pageInfo.getId());
            if (page != null)
                dojo.style(page, "display", "none");
        });
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hidePage: function(pageName)
    {
        var pageInfo = this.getPage(pageName);
        if (pageInfo != undefined)
        {
            var page = dojo.byId(pageInfo.getId());
            if (page != null)
               dojo.style(page, "display", "none");
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    showPage: function(pageInfo, transitionDir, transitionType)
    {
        if (this.enableDebugLog)
        	this.log("about to show page " + pageInfo.getName());
        var page = dojo.byId(pageInfo.getId());
        if (page != null)
        {
            dojo.style(page, "display", "");
            page.removeAttribute("disabled");
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    log: function(message)
    {
    	if (this.enableDebugLog)
           console.log(message);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getCurrentPage: function()
    {
        return this.currentPage;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    callActions: function(functions)
    {
        var runner = new com.ibm.client.Runner85201404141110({functions: functions, context: this});
        return runner.run();
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    callServerAction: function(el, args)
    {
        this.progressIndicator(true);
        if (this.enableDebugLog)
        	this.log("callServerAction called - el = ", el);
        var access = this;
        var xhrArgs =
        {
            load : function(responseObject, ioArgs)
            {
                access.progressIndicator(false);
                if (access.enableDebugLog)
                    access.log("callServerAction: action returns ", responseObject);
                if (responseObject.variables)
                {
                    dojo.safeMixin(access.variables, responseObject.variables);
                }
                if (responseObject.defaultErrorPageData)
                {
                    access.handleErrorResponse(responseObject, ioArgs);
                }
                else if (responseObject.currentPage)
                {
                    if (responseObject.errorData)
                    {
                        access.setVariable("errorData", responseObject.errorData);
                    }
                    if (responseObject.arguments)
                    {
                        access.processMethod(responseObject.currentPage, responseObject.arguments);
                    }
                    else
                    {
                        access.processAction(responseObject.currentPage);
                    }
                    access.setVariable("errorData", null);
                }
            },
            error : function(response, ioArgs)
            {
                access.progressIndicator(false);
                console.error("callServerAction error ", response, "  ioArgs = ", ioArgs);
                try
                {
                    var responseJSON = JSON.parse(response.responseText);
                    if (responseJSON.defaultErrorPageData)
                    {
                        access.handleErrorResponse(responseJSON, ioArgs);
                    }
                }
                catch (ignore) {}
                if (wpf_event_bus && wpf_event_bus.fire && access.serviceErrorEvent != null)
                    wpf_event_bus.fire(access.serviceErrorEvent, { error: response });
                return response;
            },
            handleAs: "json",
            headers:
            {
                Accept: "application/json"
            }
        };
        if (typeof el === "string")
        {
            xhrArgs.content = args;
            xhrArgs.url = this.getServerActionURL({_wef_action: el, _wef_currpg: this.currentPage});
            return dojo.xhrPost(xhrArgs);
        }
        else if (el.href)
        {
            xhrArgs.url = el.href + "&_wef_currpg=" + this.currentPage;
            return dojo.xhrGet(xhrArgs);
        }
        else if (el.tagName && el.tagName.toLowerCase() == "form")
        {
            el.action += "&_wef_currpg=" + this.currentPage;
            xhrArgs.form = el;
            if (el.enctype == "multipart/form-data")
            {
                dojo.require("dojo.io.iframe");
                return dojo.io.iframe.send(xhrArgs);
            }
            else
            {
                return dojo.xhrPost(xhrArgs);
            }
        }
        else
        {
            console.error("Unknown action type in callServerAction ", el, args);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    handleErrorResponse: function(response, ioArgs)
    {
        var expired = false;
        if (ioArgs && ioArgs.xhr && ioArgs.xhr.getResponseHeader)
        {
            if (ioArgs.xhr.getResponseHeader('X-WEF-Session-Expired') == "true")
            {
                expired = true;
            }
        }
        if (expired)
        {
            this.handleExpiredSession();
        }
        else
        {
            this.setVariable("defaultErrorPageData", response.defaultErrorPageData);
            this.processAction("defaultErrorPage");
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    handleExpiredSession: function()
    {
        window.top.location.reload();
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    progressIndicator: function(show)
    {
        try
        {
            if (show)
            {
                if (!this.progressIndicatorLocation && this.getCurrentPage() != null)
                {
                    var pageInfo = this.pages.getPage(this.getCurrentPage());
                    this.progressIndicatorLocation = pageInfo.getViewId();
                    if (wpf_event_bus && wpf_event_bus.fireLocally)
                    {
                        wpf_event_bus.fireLocally(this.instanceID + "AjaxPreLoad", {ids: [this.progressIndicatorLocation]});
                    }
                }
            }
            else if (this.progressIndicatorLocation)
            {
                if (wpf_event_bus && wpf_event_bus.fireLocally)
                {
                    wpf_event_bus.fireLocally(this.instanceID + "AjaxPreUpdate", {ids: [this.progressIndicatorLocation]});
                }
                this.progressIndicatorLocation = null;
            }
        }
        catch (cannotShowProgressIndicator)
        {
            console.error("progress indicator failed: ", cannotShowProgressIndicator);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    setVariable: function(variablePath, value)
    {
        if (this.enableDebugLog)
            this.log("setVariable " + variablePath + " : " + value);
        dojo.setObject("variables." + variablePath, value, this);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getVariable: function(variablePath)
    {
        var value = dojo.getObject("variables." + variablePath, false, this);
        if (value == null || this.isEmptyObject(value))
            value = "";
        if (this.enableDebugLog)
            this.log("getVariable " + variablePath + " : " + value);
        return value;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    isEmptyObject: function(value)
    {
        var retVal = (typeof value == "object");
        if (retVal)
        {
            for (var prop in value)
            {
                if (value.hasOwnProperty(prop))
                {
                    retVal = false;
                    break;
                }
            }
        }
        return retVal;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    exists: function(variablePath)
    {
        var variable = this.getVariable(variablePath);
        if (variable == undefined || variable == null || variable == "")
        {
            return false;
        }
        else
        {
            return true;
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getSafeArray: function(variablePath)
    {
        var retVal = null;
        if (this.exists(variablePath))
        {
            var variable = this.getVariable(variablePath);
            if (variable instanceof Array)
            {
                retVal = variable;
            }
            else
            {
                retVal = new Array(variable);
            }
        }
        else
        {
            retVal = new Array();
        }
        if (this.enableDebugLog)
            this.log("getSafeArray " + variablePath + " : " + retVal.length);
        return retVal;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    processPage: function(pageName, transitionDir, transitionType)
    {
        try
        {
            this.currentPage = pageName;
            var pageInfo = this.pages.getPage(pageName);
            if (transitionDir === undefined)
            {
                var defaultDirection = this.getVariable('ClientDefaultTransitionDirection');
                if (defaultDirection === undefined || defaultDirection === null || defaultDirection === "")
                    transitionDir = "1";
                else
                    transitionDir = defaultDirection;
            }
            if (transitionType === undefined)
            {
                var defaultType = this.getVariable('ClientDefaultTransition');
                if (defaultType === undefined || defaultType === null || defaultType === "")
                    transitionType = "slide";
                else
                    transitionType = defaultType;
            }
            if (this.enableDebugLog)
                this.log("processPage " + pageName );
            if (pageInfo.remote && pageInfo.template == null)
                this.loadRemotePage(pageInfo, transitionDir, transitionType);
            else
                this.processPageData(pageInfo, transitionDir, transitionType);
        }
        catch(ex)
        {
            if (pageName != "defaultErrorPage")
                this.handleErrorResponse({defaultErrorPageData:{errorMessage:ex.message, exceptionMessage:ex.message, stackTrace:ex.stack}});
            if (wpf_event_bus && wpf_event_bus.fire && this.pageErrorEvent != null)
                  wpf_event_bus.fire(this.pageErrorEvent, { error: ex });
            console.error("ERROR processing page data " + ex);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    processMethod: function(methodName, arguments)
    {
        var method = this[methodName];
        if (typeof method === "function")
        {
            if (arguments)
            {
                return method.apply(this, arguments);
            }
            else
            {
                return method.apply(this);
            }
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    processAction: function(actionName, transitionDir, transitionType)
    {
        if (this.pages.pageExists(actionName))
            return this.processPage(actionName, transitionDir, transitionType);
        else
        	return this.processMethod(actionName);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    prepare: function(t)
    {
    	var CODE_OUT_REGEX = /\[@=(.*?)@\]/g;
    	var CODE_REGEX = /\[@(.*?)@\]/g;
        t = t.replace(/<!--(.*?)-->/g, "");
        t = t.replace(/[\n\r]+/g, "\\n");
        t = t.replace(/\\(d)/g, "\\\\d");
        t = t.replace(/"/g, "\\\"");
        t = t.replace(CODE_OUT_REGEX, function(m, code) {
            return "\" + (" + code.replace(/\\"/g, "\"").replace(/\\n/g, "") + ") + \"";
        });
        t = t.replace(CODE_REGEX, function(m, code) {
            return  "\"; " + code.replace(/\\"/g, "\"").replace(/\\n/g, "") + " _out += \"";
        });
        t = t.replace(/webAppAccess/g, this.instanceID);
        t = "var _out = \"" + t + "\"; return _out";
        var body = "with (this) {" + t + "}";
        try
        {
            return new Function(body);
        }
        catch (compileError)
        {
            console.error("Error: prepare template - " + compileError);
            if (this.enableDebugLog)
                this.log("Template: " + body);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    loadRemotePage: function(pageInfo, transitionDir, transitionType)
    {
        var deferred = dojo.xhrGet({url :  pageInfo.remoteURL});
        var deferredList = new dojo.DeferredList([deferred]);
        var access = this;
        deferredList.addCallback(function(results){
            var page = results[0][1];
            page = page.replace(/&gt;/g, ">");
            page = page.replace(/&lt;/g, "<");
            page = page.replace(/&#39;/g, "'");
            pageInfo.template = page;
            if (access.enableDebugLog)
                access.log("Loaded remote page " + pageInfo.remoteURL);
            access.processPageData(pageInfo, transitionDir, transitionType);
        });
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getServerActionURL: function(params)
    {
        var url = this.dispatcherURL;
        var sep = url.indexOf("?") < 0 ? "?" : "&";
        for (p in params)
        {
            url += sep + p + "=" + params[p];
            sep = "&";
        }
        return url;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getText: function(fieldPath)
    {
        var text = this.getVariable(fieldPath).toString();
        text = text.replace(/</g, "&#x3C;");
        text = text.replace(/>/g, "&#x3E;");
        return text;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getMessage: function(fieldPath)
    {
        var message = this.getVariable(fieldPath);
        if (message == undefined)
            message = "";
        return message;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getIsInvalidString: function(fieldPath)
    {
        if (this.exists(fieldPath))
            message = "true";
        else
            message = "false";
        return message;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getCheckedName: function(fieldPath, currentValue)
    {
        var selectedValue = this.getVariable(fieldPath);
        var checkedName = "_bst_unchecked"; //$NON-NLS-1$
        if (selectedValue != null && selectedValue == currentValue)
            checkedName = "checked"; //$NON-NLS-1$
        return checkedName;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getCheckedAttribute: function(fieldPath, currentValue)
    {
        var selectedValue = this.getVariable(fieldPath);
        var checkedAttribute = "false"; //$NON-NLS-1$
        if (selectedValue != null && selectedValue == currentValue)
            checkedAttribute = "true"; //$NON-NLS-1$
        return checkedAttribute;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getSelected: function(fieldPath, currentValue)
    {
        var selectedValue = this.getVariable(fieldPath);
        var selectedAttribute = ""; //$NON-NLS-1$
        if (selectedValue != null && selectedValue == currentValue)
            selectedAttribute = "selected"; //$NON-NLS-1$
        return selectedAttribute;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getLookupLabel: function(keyValue, fieldPath, valueElementName, labelElementName)
    {
        var lookupVariable = this.getVariable(fieldPath);
        if (keyValue == null || keyValue == "" || lookupVariable == null)
            return "";
        var lookupTable = this.findArray(lookupVariable);
        if (lookupTable != null)
        {
            for (var i = 0; i < lookupTable.length; i++)
            {
                if (lookupTable[i][valueElementName] == keyValue)
                {
                    var name = lookupTable[i][labelElementName];
                    if (name.content == undefined)
                    {
                        return name;
                    }
                    else
                    {
                        return name.content;
                    }
                }
            }
        }
        return keyValue;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    findArray: function(variable)
    {
        for (var property in variable)
        {
            var object = variable[property];
            if (dojo.isArray(object))
                return object;
            else if (dojo.isObject(object))
            {
                var array = this.findArray(object);
                if (array)
                {
                    return array;
                }
            }
        }
        return null;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    formatDate: function(fieldPath, datePatternIn, datePatternOut)
    {
        var value = this.getVariable(fieldPath);
        if (value != null && value.length > 0)
        {
            var date = dojo.date.locale.parse(value, {datePattern: datePatternIn, selector: "date"});
            if (date)
            {
                value = dojo.date.locale.format(date, {datePattern: datePatternOut, selector: "date"});
            }
        }
        return value;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    formatNumber: function(fieldPath, numberPatternOut)
    {
        var value = this.getVariable(fieldPath);
        if (value != null && value.length > 0)
        {
            var number = dojo.number.parse(value);
            value = dojo.number.format(number, {pattern: numberPatternOut});
        }
        return value;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getTargetPage: function(pageInfo)
    {
        return dojo.byId(pageInfo.getId());
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getNewTargetPage: function(pageInfo, targetPage)
    {
        return targetPage;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    processPageData: function(pageInfo, transitionDir, transitionType)
    {
        if (pageInfo.context == undefined)
            pageInfo.context = this.prepare(pageInfo.template);
        this.hidePages();
        var targetPage = this.getTargetPage(pageInfo);
        this.destroyWidgets(pageInfo.getViewId());
        var results = pageInfo.context.apply(this);
        dojox.html.set(targetPage, results,
                {executeScripts: this.executeScripts, scriptHasHooks: false, renderStyles: true});
        targetPage = this.getNewTargetPage(pageInfo, targetPage);
        this.parseWidgets(targetPage);
        this.showPage(pageInfo, transitionDir, transitionType);
        this.trackActivation(pageInfo);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    trackActivation: function(pageInfo)
    {
        var access = this;
        var root = dojo.byId(pageInfo.getViewId());
        dojo.forEach(root.getElementsByTagName("form"), function(f) {
            function track(el)
            {
                access.setCurrentPageAndForm(pageInfo.name, f);
            };
            dojo.forEach(f.elements, function(el) {
                dojo.connect(el, "onfocus", track);
            });
            dojo.forEach(f.getElementsByTagName("a"), function(el) {
                dojo.connect(el, "onfocus", track);
            });
            var prevSubmit = f.onsubmit;
            f.onsubmit = function(event)
            {
                if (!prevSubmit || prevSubmit())
                {
                    access.callServerAction(f);
                }
                return false;
            };
        });
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    setCurrentPageAndForm: function(pageName, el)
    {
        if (this.currentPage != pageName)
        	if (this.enableDebugLog)
        	    this.log("setting current page to " + pageName);
        this.currentPage = pageName;
        var form = null;
        while (el && !form)
        {
            if (el.tagName.toLowerCase() == "form")
                form = el;
            else if (el.form)
                form = el.form;
            else
                el = el.parentNode;
        }
        if (form)
        {
            if (form != this.currentForm)
            	if (this.enableDebugLog)
            	    console.debug("setting current form to ", form);
            this.currentForm = form;
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getIsNullOrFalseForCompare: function(value)
    {
        var retVal = true;
        if (value != null && value != undefined && value != "")
        {
            if (typeof value == "boolean")
            {
                retVal = !value;
            }
            else if (typeof value == "string")
            {
                retVal = value.toLowerCase() == "false";
            }
            else if (typeof value == "number")
            {
                retVal = isNaN(value);
            }
            else
            {
                retVal = false;
            }
        }
        return retVal;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getStringValueForCompare: function(value)
    {
        var retVal = value;
        if (typeof retVal != "string")
        {
            retVal = String(retVal);
        }
        return retVal;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getCaseInsensitiveStringValueForCompare: function(value)
    {
        return this.getStringValueForCompare(value).toLowerCase();
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getNumberValueForCompare: function(value)
    {
        var retVal = value;
        if (typeof retVal != "number")
        {
            retVal = Number(retVal);
        }
        return retVal;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hideWhenFalse: function(value)
    {
        var hide = false;
        if (typeof value == "boolean")
        {
            hide = !value;
        }
        else if (typeof value == "string")
        {
            hide = (value === "false") || (value === "hide");
        }
        return this.getStyleDisplayValue(hide);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hideWhenEqual: function(value1, value2)
    {
        var hide = (value1 == value2);
        return this.getStyleDisplayValue(hide);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hideWhenNotEqual: function(value1, value2)
    {
        var hide = (value1 != value2);
        return this.getStyleDisplayValue(hide);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getStyleDisplayValue: function(hide)
    {
        return hide ? "display:none" : "display:inherit";
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getSortImage: function(name, column, imgNo)
    {
        var image = "";
        var metadata = this.getSafeArray("ClientSortMetadata.sortMetadata.collection");
        if (metadata)
        {
            for (var index = 0; index < metadata.length; index++)
            {
                if (metadata[index].name == name)
                {
                	if (metadata[index].column == column)
                	{
                		image = (imgNo == 2) ? metadata[index].sortedImage2 : metadata[index].sortedImage1;
                	}
                	else
                	{
                		image = (imgNo == 2) ? metadata[index].unsortedImage2 : metadata[index].unsortedImage1;
                	}
                    break;
                }
            }
        }
        return image;
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.PageNotFoundException85201404141110", null, {
    pageName: "",
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
        dojo.safeMixin(this,args);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    toString: function()
    {
        return "PageNotFoundException [" + this.pageName + "]";
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.PageInfo85201404141110", null, {
    name: "",
    id: null,
    wrapper: null,
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
        dojo.safeMixin(this,args);
        this.wrapper = this.id + "_wrapper";
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getId: function()
    {
        return this.wrapper;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getViewId: function()
    {
        return this.wrapper;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getName: function()
    {
        return this.name;
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Information for a client dojo mobile page.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.MobilePageInfo85201404141110", com.ibm.client.PageInfo85201404141110, {
    inner: null,
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
        this.inner = this.id;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getViewId: function()
    {
        return this.inner;
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.Pages85201404141110", null, {
    pages: [],
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
    	this.pages = [];
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    addPage: function(pageInfo)
    {
        this.pages.push(pageInfo);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getPage: function(pageName)
    {
        for (var i=0; i< this.pages.length; i++)
        {
             if (this.pages[i].name == pageName)
             {
                 return this.pages[i];
             }
        }
        if (this.enableDebugLog)
            this.log("page not found " + pageName);
        throw new com.ibm.client.PageNotFoundException85201404141110({pageName: pageName});
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getPages: function()
    {
        return this.pages;
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    pageExists: function(pageName)
    {
        for (var i = 0; i < this.pages.length; i++)
        {
            if (this.pages[i].name == pageName)
            {
                return true;
            }
        }
        return false;
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.Runner85201404141110", null, {
    functions: [],
    current: 0,
    returnValue: null,
    callback: [],
    context: {},
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    constructor: function(args)
    {
    	this.functions = [];
    	this.callback = null;
    	this.context = {};
        dojo.safeMixin(this, args);
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    run: function()
    {
        this.current = 0;
        return this.next();
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    next: function(returnValue)
    {
        var myself = this;
        this.returnValue = returnValue;
        while (this.functions && this.current < this.functions.length)
        {
            var rv = this.functions[this.current++].call(this.context);
            if (rv && rv.addCallback)
            {
                rv.addCallback(function(data) {myself.next(data);});
                return this;
            }
        }
        if (this.callback != null)
        {
            var callback = this.callback;
            this.callback = null;
            return callback(returnValue);
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    addCallback: function(fn)
    {
        this.callback = fn;
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
dojo.declare("com.ibm.client.MobileWebAppAccess85201404141110", com.ibm.client.WebAppAccess85201404141110, {
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    hidePages: function()
    {
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    showPage: function(pageInfo, transitionDir, transitionType)
    {
        var id = pageInfo.getViewId();
        var w = dijit.byId(id);
        if (w)
        {
            var v = w.getShowingView();
            if (v && (id != v.id))
                v.performTransition(id, transitionDir, transitionType);
            else if (v && v.resize)
                v.resize();
        }
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getTargetPage: function(pageInfo)
    {
        return dojo.byId(pageInfo.getId());
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    getNewTargetPage: function(pageInfo, targetPage)
    {
        var moveNode = dojo.byId(pageInfo.getViewId());
        if (moveNode != null)
        {
            moveNode.setAttribute("selected", "true");
            targetPage.parentNode.appendChild(moveNode);
        }
        else
        {
            console.error("Could not find target page " + pageInfo.getViewId());
        }
        return moveNode;
    }
});
