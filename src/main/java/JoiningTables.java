import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class JoiningTables {

    List<TableInfo> tableInfoList;

    String joiningCondition;
    JoinType joinType = JoinType.LEFT_OUTER;

}