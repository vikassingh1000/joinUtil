import lombok.ToString;

import java.util.List;

@ToString
public class JoinCheck {

    List<JoinDetail> joinDetails;

    public List<JoinDetail> getJoinDetails() {
        return joinDetails;
    }

    public void setJoinDetails(List<JoinDetail> joinDetails) {
        this.joinDetails = joinDetails;
    }
}
