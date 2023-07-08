package decorator.ui;

import login.ILoginPresenter;

public interface ILoginView extends IUnauthenticatedView {
    void setLoginPresenter(ILoginPresenter loginPresenter);
}
