package com.springbootdev.examples.entity;

import javax.persistence.*;

@Entity
@Table(name = "user") //Entity = 객체 = 테이블. instance는 오라클 시퀀스 인스턴스 이런거 때문에 이름 겹쳐서 저렇게 쓰는 건가?
//여튼 데이터베이스 객체는 entity 라고 함.
//오라클 인스턴스..
//시퀀스 인스턴스?
//테이블명 entity?

public class User {

    @Id //필수키?
    @GeneratedValue(strategy = GenerationType.AUTO) // 알아서 데이터베이스 만들고? 컨트롤러에서 객체이름.findOne(userId)  하면 자동으로 select 문 만드는 건가, where절에 userId 파라미터 넣어서?
    //그럼 더복잡한거 어떻게 하지? 웹 CURE SQL문에서는 복잡할 SQL이 없나?
    private Long id;

    private String name;

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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
