package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Step {

    @Id
    @GeneratedValue
    private Long stepNo; //단계번호
    private String stepNm; //단계명
    private String mthdlgyCd; //방법론코드

    private String beginDe; //시작일자
    private String endDe; //종요일자
    private String cmpltDe; //완료일자


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project;

    //연관관계 편의 메서드
    public void setProject(Project project) {

        if(this.project != null) {
            this.project.getSteps().remove(this);
        }

        this.project = project;
        project.getSteps().add(this);
    }




}
