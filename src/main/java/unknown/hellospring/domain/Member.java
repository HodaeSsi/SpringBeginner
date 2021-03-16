package unknown.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //"이건 디비에서 만들어주는 원소야"
    private Long id;
    
    @Column(name = "name") //db의 username 컬럼과 맵핑해줘
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
