package com.document;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.document.entity.TypeDocumentM;

@SpringBootTest
class ChallengeBackendTypeDocumentApplicationTests {

	@Test
	void getListOfDocuments() {
		List<TypeDocumentM> list = new ArrayList<>();
		list.add(TypeDocumentM.builder().code("").name("").description("").state(null).build());
	}
}