package com.javis.aplication.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GemService {

    private final OpenAiService openAiService;

    public String getGPT4Response(String prompt) {
        // ChatMessage 객체를 생성하여 사용자 메시지를 만듭니다.
        ChatMessage message = new ChatMessage("user", prompt);

        // ChatCompletionRequest를 생성하여 GPT-4에 요청합니다.
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-4o")
                .messages(List.of(message))
                .build();

        // OpenAI 서비스에서 ChatCompletionResult를 얻어옵니다.
        ChatCompletionResult result = openAiService.createChatCompletion(request);

        // 첫 번째 응답 메시지의 내용을 반환합니다.
        return result.getChoices().get(0).getMessage().getContent();
    }

    public String producingGemService(String content) {
        // content에서 개행 문자를 제거하여 JSON 포맷에 맞게 변환
        content = content.replaceAll("\\r|\\n", " ");

        String prompt = "너는 취업을 준비하는 사람의 자기소개서를 분석해야해. 자기소개서의 질에 따라서 등급을 부여해야해. 등급은 총 4단계야. 특별히 좋은 부분이 있다면 그 부분을 가려내야해. 가려내서 좋은 점들을 분석해야해. 너가 제공할 정보는 1. 특별히 좋은 부분 구절 2. 해당 구절의 등급 3. 해당 구절의 특징 4. 그 구절이 좋은 이유 총 4가지야. 너가 분석한 정보는 자기소개서에서 보석 발굴하기! 게임에 사용될거야. 너는 보석을 캐는 광부의 말투를 사용해야해. 하나의 글에서 최소 2개 최대 7개의 보석을 발굴할거야. 하나의 구절이 하나의 보석이야. 그리고 너가 제공한 답변을 가공해서 response로 응답해야해. json 이외의 다른 말은 붙이지 마. ```json ``` 이것도 붙이지마. json { gemList : { { name : string, rate : int, comment : string, answer : string } } totalScore : int, count : int, rate_count : int } - total score : 총 점수 (100점 만점) - count : 보석 전체 개수 - rate_count : 각 등급마다의 보석 개수 - line : content의 어느 부분에 해당하는지 - gemList : 보석 정보 리스트 - name(string) : 보석 이름 (=해당 구절이 좋은 이유를 하나의 단어로 표현, 게임에 나올법한 표현 사용) (ex, 트렌드에 민감한 지원자) - rate(int) : 어느 등급의 보석인지 (1 : 다이아몬드, 2: 골드, 3: 실버, 4: 브론즈) - comment(string) : 그 구절이 좋은 이유 (광부 말투) - answer(string) : 특별히 좋은 구절 user : 취업을 준비하는 학생";
//        String prompt = "안녕";
//         content를 prompt에 추가
        prompt += " " + content;

        return getGPT4Response(prompt);
    }
}
