dojo.provide("wpf.widget.RadioGroup");

dojo.require("dojox.layout.RadioGroup");

dojo.declare("wpf.widget.RadioGroup",
	dojox.layout.RadioGroup, {
		// override the buttonClass to be our own subclass
		buttonClass: "wpf.widget._RadioButton"
	}
);

dojo.declare("wpf.widget.RadioGroupFade",
	dojox.layout.RadioGroupFade, {
		// override the buttonClass to be our own subclass
		buttonClass: "wpf.widget._RadioButton"
	}
);

dojo.declare("wpf.widget.RadioGroupSlide",
	dojox.layout.RadioGroupSlide, {
		// override the buttonClass to be our own subclass
		buttonClass: "wpf.widget._RadioButton",

		// override the default easing function to remove the ugly bounce effect
		easing: "dojo.fx.easing.linear",

		// set slideFrom to a default empty string, which means to use the page setting on each content pane
		slideFrom: "",

		postCreate: function() {
			// invoke the super class postCreate (if any)
			this.inherited(arguments);
			
			// set the easing function in postCreate after attributes from the dojo widget have been applied
			if (dojo.isString(this.easing)) {
				this.easing = dojo.getObject(this.easing);
			}
		},

		_positionChild: function(page) {
			// if slideFrom has been overridden from the default empty string, then use its value for the page's slideFrom attribute
			if (this.slideFrom != "") {
				page.slideFrom = this.slideFrom;
			}
			// invoke the super class _positionChild method
			this.inherited(arguments);
		}
	}
);

dojo.declare("wpf.widget._RadioButton",
	dojox.layout._RadioButton, {
		startup: function(){
			// invoke the super class startup method
			this.inherited(arguments);

			// set the initial selected state for the button
			if (this.page.selected) {
				dojo.addClass(this.domNode, "dojoxRadioButtonSelected");
			}
		}
	}
);
