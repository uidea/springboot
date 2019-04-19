package com.springboot.controller.observer;

/***
 * 主题接口
 *
 */
public interface Subject {
	// 添加观察者
	public void registerObserver(Observer o);

	// 移除观察者
	public void removeObserver(Observer o);

	// 当主题方法改变时,这个方法被调用,通知所有的观察者
	public void notifyObserver();
}
