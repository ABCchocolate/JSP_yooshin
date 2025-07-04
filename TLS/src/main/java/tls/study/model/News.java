package tls.study.model;

import java.util.List;

import lombok.Data;


@Data
public class News {
	private int news_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
}
