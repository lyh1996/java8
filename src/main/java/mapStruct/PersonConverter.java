package mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/19 2:15 下午
 */
@Mapper
interface PersonConverter {

    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

    PersonDTO do2dto(PersonDO person);
}
