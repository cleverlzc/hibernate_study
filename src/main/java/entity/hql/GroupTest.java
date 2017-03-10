package entity.hql;

/**
 * Created by root on 17-3-8.
 */
public class GroupTest {
    private String name;
    private Long count;

    public GroupTest(){}

    public GroupTest(String name, Long count) {
        this.count = count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
