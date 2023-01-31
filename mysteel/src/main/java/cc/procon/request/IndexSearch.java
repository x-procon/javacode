package cc.procon.request;

import lombok.Data;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName IndexSearch.java
 * @Description TODO
 * @createTime 2022年04月15日 15:55
 */
@Data
public class IndexSearch {

    private String indexName;
    private QueryBuilder builder;
    /**需要从es获得的字段*/
    private String[] includes;
    /**排序字段名*/
    private String sortName;
    /**返回数量*/
    private Integer size;

    public IndexSearch() {
    }

    public IndexSearch(String indexName, String sortName, Integer size) {
        this.indexName = indexName;
        this.sortName = sortName;
        this.size = size;
    }
}
