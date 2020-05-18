package silverit.deliverables.common.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class Project {

    @Id @GeneratedValue
    private Long prjNo; //프로젝트 번호
    private String prjNm; //프로젝트 명
    private String prjBeginDe; //프로젝트 시작일자
    private String prjEndDe; //프로젝트 종료일자
    private String prjEngCdNm; //프로젝트 영문 코드 명

    @OneToMany(mappedBy = "project")
    private List<Step> steps = new ArrayList<>(); //단계 = STEP

    // 단계 연관관계 메서드
    public void setSteps(Step step){
        this.getSteps().add(step);
        step.setProject(this);
    }
}
