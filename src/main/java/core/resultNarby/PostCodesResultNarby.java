package core.resultNarby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostCodesResultNarby {

    Integer status;
    ArrayList<result> result = new ArrayList<result>();

}
