package cc.procon.model.po;

/**
 * 触发器PO
 *
 * @author procon
 * @since 2022-09-26
 */
public class TriggerPO {

    /** 拥有者**/
    private String owner;

    /** 名称**/
    private String name;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
