package validators;


import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestValidator {
    private JSONObject response;
    private JSONArray responseArray;
    private int responseCode;

    public boolean validaExecuteGet(Response response) {
        this.response = new JSONObject(response.getBody().asString());
        this.responseCode = response.getStatusCode();
        try {
            if(this.responseCode == 200 && this.response.length() == 0){
                return true;
            }
        }catch (Exception e){
            return false;
        }
      return true;
    }

    public boolean validaExecutePOST(Response response) {
        this.response = new JSONObject(response.getBody().asString());
        this.responseCode = response.getStatusCode();
        JSONObject expectedResult = null;
        try {
            if(this.responseCode == 201 && this.response.length() > 0){
                expectedResult = new JSONObject("{\n" +
                        "    \"name\": \"String\",\n" +
                        "    \"job\": \"String\",\n" +
                        "    \"id\": \"0\",\n" +
                        "    \"createdAt\": \"2021-09-03T23:58:23.435Z\"\n" +
                        "}");
            }
        }catch (Exception e){
            return false;
        }
        return expectedResult.equals(this.response);
    }
}
