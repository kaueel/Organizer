package Models;

import javax.persistence.*;

@Entity
public class ActionPlanLawSuit {
    private ActionPlan actionPlanByActionPlanId;
    private Integer this_id;

    @ManyToOne
    @JoinColumn(name = "ActionPlanID", referencedColumnName = "ID", nullable = false)
    public ActionPlan getActionPlanByActionPlanId() {
        return actionPlanByActionPlanId;
    }

    public void setActionPlanByActionPlanId(ActionPlan actionPlanByActionPlanId) {
        this.actionPlanByActionPlanId = actionPlanByActionPlanId;
    }



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getThis_id() {
        return this_id;
    }

    public void setThis_id(Integer this_id) {
        this.this_id = this_id;
    }
}
