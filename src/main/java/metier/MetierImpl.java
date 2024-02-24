package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier{
    IDao iDao;


    public MetierImpl(@Qualifier("dao") IDao iDao) {
        this.iDao = iDao;
    }

    @Override
    public double calcul() {
        double t=iDao.getData();
        t*=20;
        return t;
    }

    public void setDao(IDao iDao) {
        this.iDao = iDao;
    }
}
