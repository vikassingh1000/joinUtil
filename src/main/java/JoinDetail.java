import lombok.ToString;

import java.util.List;

@ToString
public class JoinDetail {

    List<TableMeta> tableMetas;

    public List<TableMeta> getTableMetas() {
        return tableMetas;
    }

    public void setTableMetas(List<TableMeta> tableMetas) {
        this.tableMetas = tableMetas;
    }
}
