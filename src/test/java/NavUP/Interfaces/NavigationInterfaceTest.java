package NavUP.Interfaces;

import NavUP.Interfaces.NavigationModule.Navigation;

/**
 * Created by victor on 2017/05/01.
 */
class NavigationInterfaceTest {

    //Navigation object instance
    Navigation navModule = new Navigation();

    //getRoute() sample input:
    //pointLocations will be a JSON string with two Locations:
    // There should be a way to differentiate between a static and dynamic preferences and restrictions.
    // The static ones are in the navigation database which it will use to make decisions.
    // The dynamic ones should possibly be specified by access according to user selections dynamically - customised to user.
    // This function should also include a preferences and restrictions objects.
    ///{
    //    userID: String,
    //    source:
    //    {
    //        lat: double,
    //        long: double
    //    },
    //
    //    destination:
    //    {
    //        lat: double,
    //        long: double
    //    },
    //
    //    restrictions:
    //    {
    //        isDisabled: boolean
    //    },
    //
    //    preferences:
    //    {
    //        maximumRouteLength: double
    //    }
    //}
    //
    //getRoute() sample output:
    //We expect a JSON string with a single rout as an array of locations to be returned..of the form:
    //{
    //    length: double,
    //    waypoints:
    //    [
    //        {
    //            lat: double,
    //            long: double
    //        }
    //        ,...
    //    ]
    //}
    //

    @org.junit.jupiter.api.Test
    void getRoute() {

        // From HB to CSE (indoor to indoor)
        String pointLocations1 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"source\":"
                        + " {"
                        + "     \"lat\": \"-25.7552969\","
                        + "     \"long\": \"28.2308200\""
                        + " },"
                        + " \"destination\":"
                        + " {"
                        + "     \"lat\": \"-25.7554499\","
                        + "     \"long\": \"28.2312627\""
                        + " },"
                        + " \"restrictions\":"
                        + " {"
                        + "     \"isDisabled\": \"false\""
                        + " },"
                        + " \"preferences\":"
                        + " {"
                        + "     \"maximumRouteLength\": \"20\""
                        + " }"
                        +
                        "}";

        //navModule.getRoute(pointLocations1);
        //System.out.println(navModule.getRoute(pointLocations1));

        // From outside of HB to outside of Theology building (outdoor to outdoor)
        String pointLocations2 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"source\":"
                        + " {"
                        + "     \"lat\": \"-25.754885\","
                        + "     \"long\": \"28.231372\""
                        + " },"
                        + " \"destination\":"
                        + " {"
                        + "     \"lat\": \"-25.754943\","
                        + "     \"long\": \"28.229339\""
                        + " },"
                        + " \"restrictions\":"
                        + " {"
                        + "     \"isDisabled\": \"false\""
                        + " },"
                        + " \"preferences\":"
                        + " {"
                        + "     \"maximumRouteLength\": \"20\""
                        + " }"
                        +
                        "}";
        // From IT Building to outside of HB (indoor to outdoor)
        String pointLocations3 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"source\":"
                        + " {"
                        + "     \"lat\": \"-25.755619\","
                        + "     \"long\": \"28.232563\""
                        + " },"
                        + " \"destination\":"
                        + " {"
                        + "     \"lat\": \"-25.755160\","
                        + "     \"long\": \"28.231310\""
                        + " },"
                        + " \"restrictions\":"
                        + " {"
                        + "     \"isDisabled\": \"false\""
                        + " },"
                        + " \"preferences\":"
                        + " {"
                        + "     \"maximumRouteLength\": \"20\""
                        + " }"
                        +
                        "}";

        // From outside of Centenary to Merensky Library (outdoor to indoor)
        String pointLocations4 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"source\":"
                        + " {"
                        + "     \"lat\": \"-25.754112\","
                        + "     \"long\": \"28.232930\""
                        + " },"
                        + " \"destination\":"
                        + " {"
                        + "     \"lat\": \"-25.755169\","
                        + "     \"long\": \"28.230470\""
                        + " },"
                        + " \"restrictions\":"
                        + " {"
                        + "     \"isDisabled\": \"false\""
                        + " },"
                        + " \"preferences\":"
                        + " {"
                        + "     \"maximumRouteLength\": \"20\""
                        + " }"
                        +
                        "}";



        //Add a route to the cache
        //System.out.println(navModule.getRoute(pointLocations1));

        //assertNotNull(navModule.getRoute(pointLocations1));
    }

    @org.junit.jupiter.api.Test
    void dropPin() {
        //Strings to test pin functionality

        // Drop pin on IT Building
        String pin1 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"-25.755619\","
                        + "     \"long\": \"28.232563\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.dropPin(pin1);

        // Drop pin on outside Centenary
        String pin2 =
                "{"
                        + " \"userID\": \"user02\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"-25.754112\","
                        + "     \"long\": \"28.232930\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.dropPin(pin2);

        // Drop pin that's already added (similar to pin1)
        navModule.dropPin(pin1);

        // Drop out of bounds pin (Brooklyn Mall)
        String pin3 =
                "{"
                        + " \"userID\": \"user02\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"-25.771800\","
                        + "     \"long\": \"28.234555\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.dropPin(pin3);
    }

    @org.junit.jupiter.api.Test
    void removePin() {

        // Drop and remove pin on IT Building (indoor)
        String pin4 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"-25.755619\","
                        + "     \"long\": \"28.232563\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.dropPin(pin4);
        navModule.removePin(pin4);

        // Drop and remove pin on outside Centenary (outdoor)
        String pin5 =
                "{"
                        + " \"userID\": \"user02\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"-25.754112\","
                        + "     \"long\": \"28.232930\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.dropPin(pin5);
        navModule.removePin(pin5);

        // Remove pin that doesn't exist
        String pin3 =
                "{"
                        + " \"userID\": \"user01\","
                        + " \"pin\":"
                        + " {"
                        + "     \"lat\": \"1\","
                        + "     \"long\": \"2\","
                        + "     \"customName\": \"DatPoint\""
                        + " }"
                        +
                        "}";

        navModule.removePin(pin3);

    }
}

