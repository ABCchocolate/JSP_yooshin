package com.sinse.hiberasync.util;

import lombok.Data;

@Data
public class Message {
	private String result; //success, fail
	private String msg; //보내고싶은 처리 메시
}
