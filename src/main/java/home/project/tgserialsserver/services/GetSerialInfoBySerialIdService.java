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
        Optional<GetSerialInfoBySerialIdResponseDto> oSerialInfo = getSerialInfoBySerialIdRequest.execute(serialId);
        if (oSerialInfo.isPresent()) {
            GetSerialInfoBySerialIdResponseDto serialInfo = oSerialInfo.get();
            return hasLength(serialInfo.getNameRu()) ? serialInfo.getNameRu() : serialInfo.getNameEn();
        }
        return "NaN";
    }
}
