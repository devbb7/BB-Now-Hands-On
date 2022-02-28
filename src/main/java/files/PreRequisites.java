package files;

import io.cucumber.java.en.Given;

public class PreRequisites {
    @Given("I do all prerequisites setup in {string} env")
    public void iDoAllPrerequisitesSetupInEnv(String env_type) {
        Constants.env_type=env_type;
        Constants.setBaseURI1();
        Constants.setBaseURI2();
        Constants.setBBADMINAUTHTOKEN();
        Constants.setFc_id();
        Constants.setMemberAddr();
        Constants.setMemberID();
        Constants.setVid();
    }
}
