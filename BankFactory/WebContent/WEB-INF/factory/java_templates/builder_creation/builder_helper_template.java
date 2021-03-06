/**
 * Description:  WEF builder helper class
 *
 * Licensed Materials - Property of IBM 
 * 5724-O03
 * (C) Copyright 2012. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use. 
 *
 * This Java source file was generated by the Web Experience Factory.
 *
 * Do not edit generated code within the following comments /*##GENERATED_...
 *
 */

import java.util.*;
import com.bowstreet.webapp.*;
import com.bowstreet.util.XmlUtil;
import com.bowstreet.util.StringUtil;
import com.bowstreet.util.IXml;
import com.bowstreet.util.WrappedException;
import com.bowstreet.builders.webapp.methods.BuilderHelper;


/**
 * Helper LJO for a builder.  An instance of this class will be created
 * every time the generated WebApp is brought into a user's
 * session, so session-specific data can be stored here.
 */
public class ClassNames extends BuilderHelper
{
    /**
     * This is an example of a helper method can get indirect values and properties at runtime.
     * To access properties or indirect values, call the generated accessor methods.
     */
    public String testMethod(WebAppAccess webAppAccess)
    {
        /*##GENERATED_BODY_BEGIN#PropertyAccessorCode#*/
        /*##GENERATED_BODY_END*/


        // @todo Replace this with your helper code.
        return "Hello from model " + webAppAccess.getModelName();
    }

}
