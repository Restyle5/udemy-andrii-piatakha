package com.itbulls.rahman.entity;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber implements Subscriber<Integer> {
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Subscriber: Subscribed");
		System.out.println(subscription);
		this.subscription = subscription;
		subscription.request(1); // Request the first item when subscribed
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("Subscriber: Received item " + item);
		// Transform the integer into a string and pass it downstream
		submit(String.valueOf(item * 2));
		subscription.request(1); // Request the next item
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Subscriber: Error - " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("Subscriber: Completed");
		subscription.cancel();
	}

	// Helper method to submit an item downstream
	private void submit(String item) {
		System.out.println("Subscriber: Emitting item " + item);
	}

}