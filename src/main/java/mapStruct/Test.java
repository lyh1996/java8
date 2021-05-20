package mapStruct;

import java.util.Date;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/19 2:18 下午
 */
public class Test {
    public static void main(String[] args) {
        PersonDO personDO = new PersonDO();
        personDO.setName("Hollis");
        personDO.setAge(26);
        personDO.setBirthday(new Date());
        personDO.setId(1);
        //personDO.setGender(Gender.getDesc(0));
        PersonDTO personDTO = PersonConverter.INSTANCE.do2dto(personDO);
        System.out.println(personDTO);

    }
}
