package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    IDao iDao;

    public MetierImpl() {
    }

    public MetierImpl(IDao iDao) {
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
