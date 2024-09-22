package open.source.reporter.util;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface MapStructConverter {
    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);
}

