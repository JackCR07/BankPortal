/**
 * Description:  WEF builder regen class for model-based builder
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
 */
import com.bowstreet.webapp.*;
import com.bowstreet.generation.*;
import com.bowstreet.util.*;
import com.bowstreet.builders.webapp.foundation.*;
import com.bowstreet.builders.webapp.methods.BuilderHelperUtil;

/**
 * Bowstreet builder regen class for for model-based builder
 */
public class ClassName extends com.bowstreet.builders.webapp.ImportedModelBuilder
{

    public static int INPUT_PREFIX_LENGTH = INPUT_PREFIX.length();

    /**
     * Interface that has constants for all the builder input names
     */
    static public interface Constants
    {
	}

	/**
	 * doBuilderCall - This is called during builder regen.  Most work will be done by base class.
	 */
	public void doBuilderCall(GenContext genContext, WebApp webApp, BuilderCall builderCall, BuilderInputs builderInputs)
	{
		// These two inputs are required by the ImportedModelBuilder code
		builderInputs.setString("ModelName", MODEL_NAME);
		builderInputs.setBoolean("SetProfiledInputValues", true);
		builderInputs.setString("UniquePattern", "basename"); // set the name which will be replaced by the "Name" input

		// call ImportedModel base class
		super.doBuilderCall(genContext, webApp, builderCall, builderInputs);

		// If you need to call any other builders explicitly (using builder API), you can do it here


    }

    /**
     * This method is called by ImportedModelBuilder for every profiled
     * input in the imported model.  It must return the desired builder input value.
     * Builder inputs can be String, IXml, Object, or Boolean (depending on the BuilderDef).
     */
    protected Object getInputValue(BuilderInputs builderInputs, String builderInputName)
    {
        if (builderInputName == null || builderInputName.length() == 0)
            return null;

        // Expect to see this prefix on all profiled inputs in the base model.
        if (builderInputName.startsWith(INPUT_PREFIX))
        {
            String profileEntryName = builderInputName.substring(INPUT_PREFIX_LENGTH);

			// Any special cases for builder inputs can be handled here, by
			// looking for particular profile entry names.

			/*
			// Example of changing one input in the imported model based on some builder input
			if ("HideSearch".equals(profileEntryName))
			{
				// Set "hide" to the opposite of "show" input (ShowSearch would be an input to this builder).
                boolean hide = !builderInputs.getBoolean(Constants.ShowSearch, false);
				return new Boolean(hide).toString();
			}
			*/

            // Common case for profiled inputs, where the profile entry name
            // matches the builder input name for this builder.
            Object val = super.getInputValue(builderInputs, profileEntryName);
            return val;
		}

		// For all other inputs, let the base class get the value
        return super.getInputValue(builderInputs, builderInputName);
    }
}
