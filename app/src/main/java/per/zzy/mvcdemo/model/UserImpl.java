package per.zzy.mvcdemo.model;

public class UserImpl implements IUser {
    @Override
    public void getUser(User user, OnUserListener listener) {
        if("dnw".equals(user.getName())){
            listener.onSuccess(user);
        }else{
            listener.onError();
        }
    }
}
