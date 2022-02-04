package home.project.tgserialsserver.services;

import home.project.tgserialsserver.requests.getserialinfobyserialid.GetSerialInfoBySerialIdRequest;
import home.project.tgserialsserver.requests.getserialinfobyserialid.response.GetSerialInfoBySerialIdResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.StringUtils.hasLength;

@Service
public class GetSerialInfoBySerialIdService {

    private final GetSerialInfoBySerialIdRequest getSerialInfoBySerialIdRequest;

    public GetSerialInfoBySerialIdService(GetSerialInfoBySerialIdRequest getSerialInfoBySerialIdRequest) {
        this.getSerialInfoBySerialIdRequest = getSerialInfoBySerialIdRequest;
    }

    public String getSerialNameBySerialId(Long serialId) {
        System.out.println("Get name from serial " + serialId);
        Optional<GetSerialInfoBySerialIdResponseDto> oSerialInfo = getSerialInfoBySerialIdRequest.execute(serialId);
        if (oSerialInfo.isPresent()) {
            GetSerialInfoBySerialIdResponseDto serialInfo = oSerialInfo.get();
            if (hasLength(serialInfo.getNameRu())) {
                return serialInfo.getNameRu();
            }
            if (hasLength(serialInfo.getNameEn())) {
                return serialInfo.getNameEn();
            }
            if (hasLength(serialInfo.getNameOriginal())) {
                return serialInfo.getNameOriginal();
            }
        }
        return "";
    }
}
