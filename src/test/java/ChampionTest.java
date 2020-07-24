import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {
        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
        assertTrue(emptyList.size() == 0);
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
        assertFalse(lck == "");
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
        assertTrue(lck == null);
    }

    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        assertThat(sampleString1, is(startsWith(startString)));
        assertThat(sampleString1, anyOf(startsWith(startString), containsString((endString))));
        assertThat(sampleString2, is(endsWith(endString)));
        assertThat(sampleString2, is(startsWith(startString)));
        assertThat(sampleString2, containsString((endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));
        assertThat(4.27, closeTo(4, 0.7));
        //assertThat(3.14, closeTo(3, 0.1)); -> 오류발생
        //소수점범위가 너무 적기 때문
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        String str = "";
        assertThat(championList.get(2), anything());
        //championList 3번째의 값을 가져왔을 때, 어느 값이어도 (anything) 존재만 하면 상관없다

        //anything()에는 null값도 포함
        assertThat(str, anything());

        //assertThat(championList.get(6), anything());
        //참조할 수 있는 범위를 벗어나면 오류발생
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        /*(참고) championList가 해당 메소드에 존재하지 않지만 사용가능한 이유
             -> @Before를 통해서 Setup 메소드를 한번 수행하기 때문*/
        assertThat(championList, hasSize(5)); //championList 객체 전체를 주면 사이즈를 계산
        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));

        assertThat(Arrays.asList("a", "b"), hasSize(2));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
        assertTrue(supportChamp.getName().equals("타릭"));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));

        //"position"이 있는지 확인하고, 그 값이 "탑"과 같은지
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));

        assertThat(championList.get(1), hasProperty("position", equalTo("정글")));
        assertThat(championList.get(2), hasProperty("name", equalTo("르블랑")));
        assertThat(championList.get(3), hasProperty("name", equalTo("베인")));

    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");

        //list에 "루시안"이 있는지
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(5), hasToString("블라디미르"));

        assertThat(championList.get(3).getName(), hasToString("베인"));

        //assertThat(champListNames.get(0), hasToString("루시"));  ->"루시"를 넣으면 오류. hasToString()은 문자열 전체를 비교하기 때문.
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");

        List<String> championPosition1 = Arrays.asList("탑", "정글", "미드", "바텀");
        List<String> championPosition2 = Arrays.asList("탑", "정글", "미드", "바텀");

        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championPosition1, samePropertyValuesAs(championPosition2));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        //객체가 확정되지 않았을 때 감싸주는 객체
        //position이 "탑"
        Optional<Champion> filteredChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filteredChampion.get().getName();
        String champPosition = filteredChampion.get().getPosition();

        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));

        assertTrue(champPosition.equals("탑"));
        assertThat("탑", equalTo(champPosition));
    }
}