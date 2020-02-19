package com.example.animals.pojo;

import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_award")
@ToString
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_award",comment="打赏关系表")
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "animal_id")
    private Long animalId;

    private Double money;
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return animal_id
     */
    public Long getAnimalId() {
        return animalId;
    }

    /**
     * @param animalId
     */
    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    /**
     * @return money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}