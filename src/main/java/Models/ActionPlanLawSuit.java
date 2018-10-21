package Models;

import javax.persistence.*;

@Entity
public class ActionPlanLawSuit {
    private ActionPlan actionPlanByActionPlanId;

    @ManyToOne
    @JoinColumn(name = "ActionPlanID", referencedColumnName = "ID", nullable = false)
    public ActionPlan getActionPlanByActionPlanId() {
        return actionPlanByActionPlanId;
    }

    public void setActionPlanByActionPlanId(ActionPlan actionPlanByActionPlanId) {
        this.actionPlanByActionPlanId = actionPlanByActionPlanId;
    }

    private String this_id;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String getThis_id() {
        return this_id;
    }

    public void setThis_id(String this_id) {
        this.this_id = this_id;
    }
}
