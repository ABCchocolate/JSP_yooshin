package mall.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "Notice")
public class Notice {
	@Id
	private int notice_id;
	
	private String title;
	private String writer;
	private String content;
	@Column(name="regDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	private int hit;
}
