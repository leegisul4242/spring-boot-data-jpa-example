package com.springbootdev.examples.entity;

import javax.persistence.*;

@Entity
@Table(name = "user") //Entity = ��ü = ���̺�. instance�� ����Ŭ ������ �ν��Ͻ� �̷��� ������ �̸� ���ļ� ������ ���� �ǰ�?
//��ư �����ͺ��̽� ��ü�� entity ��� ��.
//����Ŭ �ν��Ͻ�..
//������ �ν��Ͻ�?
//���̺�� entity?

public class User {

    @Id //�ʼ�Ű?
    @GeneratedValue(strategy = GenerationType.AUTO) // �˾Ƽ� �����ͺ��̽� �����? ��Ʈ�ѷ����� ��ü�̸�.findOne(userId)  �ϸ� �ڵ����� select �� ����� �ǰ�, where���� userId �Ķ���� �־?
    //�׷� �������Ѱ� ��� ����? �� CURE SQL�������� ������ SQL�� ����?
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
