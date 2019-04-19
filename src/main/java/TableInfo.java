import lombok.ToString;

import java.util.Set;

@ToString
public class TableInfo {

    TableMeta tableMeta;
    String filterCondition;
    // By default, we will load all columns
    String columnSelections ="*";
    Set<String> joiningColumns;

    public String getColumnSelections() {
        return columnSelections;
    }

    public void setColumnSelections(String columnSelections) {
        this.columnSelections = columnSelections;
    }

    public TableMeta getTableMeta() {
        return tableMeta;
    }

    public void setTableMeta(TableMeta tableMeta) {
        this.tableMeta = tableMeta;
    }

    public String getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(String filterCondition) {
        this.filterCondition = filterCondition;
    }

    public Set<String> getJoiningColumns() {
        return joiningColumns;
    }

    public void setJoiningColumns(Set<String> joiningColumns) {
        this.joiningColumns = joiningColumns;
    }
}
