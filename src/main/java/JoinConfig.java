import lombok.ToString;

@ToString
public class JoinConfig {

    private JoinCheck joinCheck;

    public JoinCheck getJoinCheck() {
        return joinCheck;
    }

    public void setJoinCheck(JoinCheck joinCheck) {
        this.joinCheck = joinCheck;
    }
}
