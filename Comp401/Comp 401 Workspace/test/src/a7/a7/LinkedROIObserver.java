package a7;

public interface LinkedROIObserver 
extends ROIObserver{
	Region getRegion();
	ROIObserver getROIObserver();
}
