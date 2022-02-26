package files.pojo;

import java.util.List;

public class JobAssignmentResponse {
    private List<Picking> picking;

    public List<Picking> getPicking() {
        return picking;
    }

    public void setPicking(List<Picking> picking) {
        this.picking = picking;
    }
}
