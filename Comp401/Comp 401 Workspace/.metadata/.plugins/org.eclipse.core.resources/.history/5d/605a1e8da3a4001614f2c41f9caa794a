package a7;
/*
 * Takoda Ren
 * November 06, 2016
 */
public class LinkedROIObserverImpl
implements LinkedROIObserver{
		private ROIObserver observer;
		private Region region;
		
		
	public LinkedROIObserverImpl(ROIObserver observer, Region region){
		if(observer == null || region == null)
			throw new IllegalArgumentException
			("Observer or region is null");
		this.observer = observer;
		this.region = region;
	}
	
	@Override
	public Region getRegion(){
		return region;
	}
	
	@Override
	public void notify(ObservablePicture picture, Region changed_region){
		observer.notify(picture, changed_region);
	}
	
	@Override
	public ROIObserver getROIObserver(){
		return observer;
	}
}


