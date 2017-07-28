package com.linnik.wickiup.patterns._3_behavioral._8_state;

/**
 * @author LinnykOleh
 */
public class Fan {

	private State fanOffState;
	private State fanLowState;
	private State fanMedState;
	private State fanHighState;

	private State state;

	public Fan() {
		this.fanOffState = new FanOffState(this);
		this.fanLowState = new FanLowState(this);
		this.fanMedState = new FanMedState(this);
		this.fanHighState = new FanHighState(this);

		this.state = fanOffState;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getFanOffState() {
		return fanOffState;
	}

	public State getFanLowState(){
		return fanLowState;
	}

	public State getFanMedState() {
		return fanMedState;
	}


	public State getFanHighState() {
		return fanHighState;
	}

	public void pullChain(){
		state.handleRequest();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
