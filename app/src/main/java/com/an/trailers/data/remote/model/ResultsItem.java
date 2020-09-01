package com.an.trailers.data.remote.model;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(primaryKeys = ("artistId"))
public class ResultsItem implements Comparable<ResultsItem>, Parcelable {
	private String artworkUrl100;

	public ResultsItem(String artworkUrl100, int trackTimeMillis, String country, String previewUrl, int artistId, String trackName, String collectionName, String artistViewUrl, int discNumber, int trackCount, String artworkUrl30, String wrapperType, String currency, int collectionId, boolean isStreamable, String trackExplicitness, String collectionViewUrl, int trackNumber, String releaseDate, String kind, int trackId, double collectionPrice, int discCount, String primaryGenreName, double trackPrice, String collectionExplicitness, String trackViewUrl, String artworkUrl60, String trackCensoredName, String artistName, String collectionCensoredName, String collectionArtistName, int collectionArtistId, String collectionArtistViewUrl, String contentAdvisoryRating, String longDescription, double trackHdRentalPrice, double collectionHdPrice, double trackHdPrice, double trackRentalPrice, boolean hasITunesExtras, String shortDescription,String kart) {
		this.artworkUrl100 = artworkUrl100;
		this.trackTimeMillis = trackTimeMillis;
		this.country = country;
		this.previewUrl = previewUrl;
		this.artistId = artistId;
		this.trackName = trackName;
		this.collectionName = collectionName;
		this.artistViewUrl = artistViewUrl;
		this.discNumber = discNumber;
		this.trackCount = trackCount;
		this.artworkUrl30 = artworkUrl30;
		this.wrapperType = wrapperType;
		this.currency = currency;
		this.collectionId = collectionId;
		this.isStreamable = isStreamable;
		this.trackExplicitness = trackExplicitness;
		this.collectionViewUrl = collectionViewUrl;
		this.trackNumber = trackNumber;
		this.releaseDate = releaseDate;
		this.kind = kind;
		this.trackId = trackId;
		this.collectionPrice = collectionPrice;
		this.discCount = discCount;
		this.primaryGenreName = primaryGenreName;
		this.trackPrice = trackPrice;
		this.collectionExplicitness = collectionExplicitness;
		this.trackViewUrl = trackViewUrl;
		this.artworkUrl60 = artworkUrl60;
		this.trackCensoredName = trackCensoredName;
		this.artistName = artistName;
		this.collectionCensoredName = collectionCensoredName;
		this.collectionArtistName = collectionArtistName;
		this.collectionArtistId = collectionArtistId;
		this.collectionArtistViewUrl = collectionArtistViewUrl;
		this.contentAdvisoryRating = contentAdvisoryRating;
		this.longDescription = longDescription;
		this.trackHdRentalPrice = trackHdRentalPrice;
		this.collectionHdPrice = collectionHdPrice;
		this.trackHdPrice = trackHdPrice;
		this.trackRentalPrice = trackRentalPrice;
		this.hasITunesExtras = hasITunesExtras;
		this.shortDescription = shortDescription;
		this.kart = kart;
	}

	private int trackTimeMillis;
	private String country;
	private String previewUrl;
	private int artistId;
	private String trackName;
	private String collectionName;
	private String artistViewUrl;
	private int discNumber;
	private int trackCount;
	private String artworkUrl30;
	private String wrapperType;
	private String currency;
	private int collectionId;
	private boolean isStreamable;
	private String trackExplicitness;
	private String collectionViewUrl;
	private int trackNumber;
	private String releaseDate;
	private String kind;
	private int trackId;
	private double collectionPrice;
	private int discCount;
	private String primaryGenreName;
	private double trackPrice;
	private String collectionExplicitness;
	private String trackViewUrl;
	private String artworkUrl60;
	private String trackCensoredName;
	private String artistName;
	private String collectionCensoredName;
	private String collectionArtistName;
	private int collectionArtistId;
	private String collectionArtistViewUrl;
	private String contentAdvisoryRating;
	private String longDescription;
	private double trackHdRentalPrice;
	private double collectionHdPrice;
	private double trackHdPrice;
	private double trackRentalPrice;
	private boolean hasITunesExtras;
	private String shortDescription;
	private String kart;

	protected ResultsItem(Parcel in) {
		artworkUrl100 = in.readString();
		trackTimeMillis = in.readInt();
		country = in.readString();
		previewUrl = in.readString();
		artistId = in.readInt();
		trackName = in.readString();
		collectionName = in.readString();
		artistViewUrl = in.readString();
		discNumber = in.readInt();
		trackCount = in.readInt();
		artworkUrl30 = in.readString();
		wrapperType = in.readString();
		currency = in.readString();
		collectionId = in.readInt();
		isStreamable = in.readByte() != 0;
		trackExplicitness = in.readString();
		collectionViewUrl = in.readString();
		trackNumber = in.readInt();
		releaseDate = in.readString();
		kind = in.readString();
		trackId = in.readInt();
		collectionPrice = in.readDouble();
		discCount = in.readInt();
		primaryGenreName = in.readString();
		trackPrice = in.readDouble();
		collectionExplicitness = in.readString();
		trackViewUrl = in.readString();
		artworkUrl60 = in.readString();
		trackCensoredName = in.readString();
		artistName = in.readString();
		collectionCensoredName = in.readString();
		collectionArtistName = in.readString();
		collectionArtistId = in.readInt();
		collectionArtistViewUrl = in.readString();
		contentAdvisoryRating = in.readString();
		longDescription = in.readString();
		trackHdRentalPrice = in.readDouble();
		collectionHdPrice = in.readDouble();
		trackHdPrice = in.readDouble();
		trackRentalPrice = in.readDouble();
		hasITunesExtras = in.readByte() != 0;
		shortDescription = in.readString();
		kart = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

    public ResultsItem() {

    }

    public String getArtworkUrl100(){
		return artworkUrl100;
	}

	public int getTrackTimeMillis(){
		return trackTimeMillis;
	}

	public String getCountry(){
		return country;
	}

	public String getPreviewUrl(){
		return previewUrl;
	}

	public int getArtistId(){
		return artistId;
	}

	public String getTrackName(){
		return trackName;
	}

	public String getCollectionName(){
		return collectionName;
	}

	public String getArtistViewUrl(){
		return artistViewUrl;
	}

	public int getDiscNumber(){
		return discNumber;
	}

	public int getTrackCount(){
		return trackCount;
	}

	public String getArtworkUrl30(){
		return artworkUrl30;
	}

	public String getWrapperType(){
		return wrapperType;
	}

	public String getCurrency(){
		return currency;
	}

	public int getCollectionId(){
		return collectionId;
	}

	public boolean isIsStreamable(){
		return isStreamable;
	}

	public String getTrackExplicitness(){
		return trackExplicitness;
	}

	public String getCollectionViewUrl(){
		return collectionViewUrl;
	}

	public int getTrackNumber(){
		return trackNumber;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getKind(){
		return kind;
	}

	public int getTrackId(){
		return trackId;
	}

	public double getCollectionPrice(){
		return collectionPrice;
	}

	public int getDiscCount(){
		return discCount;
	}

	public String getPrimaryGenreName(){
		return primaryGenreName;
	}

	public double getTrackPrice(){
		return trackPrice;
	}

	public String getCollectionExplicitness(){
		return collectionExplicitness;
	}

	public String getTrackViewUrl(){
		return trackViewUrl;
	}

	public String getArtworkUrl60(){
		return artworkUrl60;
	}

	public String getTrackCensoredName(){
		return trackCensoredName;
	}

	public String getArtistName(){
		return artistName;
	}

	public String getCollectionCensoredName(){
		return collectionCensoredName;
	}

	public String getCollectionArtistName(){
		return collectionArtistName;
	}

	public int getCollectionArtistId(){
		return collectionArtistId;
	}

	public String getCollectionArtistViewUrl(){
		return collectionArtistViewUrl;
	}

	public String getContentAdvisoryRating(){
		return contentAdvisoryRating;
	}

	public String getLongDescription(){
		return longDescription;
	}

	public double getTrackHdRentalPrice(){
		return trackHdRentalPrice;
	}

	public double getCollectionHdPrice(){
		return collectionHdPrice;
	}

	public double getTrackHdPrice(){
		return trackHdPrice;
	}

	public double getTrackRentalPrice(){
		return trackRentalPrice;
	}

	public boolean isHasITunesExtras(){
		return hasITunesExtras;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public String getKart(){
		return kart;
	}

	public int compareTo(ResultsItem b) {
		return this.getTrackName().compareTo(b.getTrackName());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(artworkUrl100);
		dest.writeInt(trackTimeMillis);
		dest.writeString(country);
		dest.writeString(previewUrl);
		dest.writeInt(artistId);
		dest.writeString(trackName);
		dest.writeString(collectionName);
		dest.writeString(artistViewUrl);
		dest.writeInt(discNumber);
		dest.writeInt(trackCount);
		dest.writeString(artworkUrl30);
		dest.writeString(wrapperType);
		dest.writeString(currency);
		dest.writeInt(collectionId);
		dest.writeByte((byte) (isStreamable ? 1 : 0));
		dest.writeString(trackExplicitness);
		dest.writeString(collectionViewUrl);
		dest.writeInt(trackNumber);
		dest.writeString(releaseDate);
		dest.writeString(kind);
		dest.writeInt(trackId);
		dest.writeDouble(collectionPrice);
		dest.writeInt(discCount);
		dest.writeString(primaryGenreName);
		dest.writeDouble(trackPrice);
		dest.writeString(collectionExplicitness);
		dest.writeString(trackViewUrl);
		dest.writeString(artworkUrl60);
		dest.writeString(trackCensoredName);
		dest.writeString(artistName);
		dest.writeString(collectionCensoredName);
		dest.writeString(collectionArtistName);
		dest.writeInt(collectionArtistId);
		dest.writeString(collectionArtistViewUrl);
		dest.writeString(contentAdvisoryRating);
		dest.writeString(longDescription);
		dest.writeDouble(trackHdRentalPrice);
		dest.writeDouble(collectionHdPrice);
		dest.writeDouble(trackHdPrice);
		dest.writeDouble(trackRentalPrice);
		dest.writeByte((byte) (hasITunesExtras ? 1 : 0));
		dest.writeString(shortDescription);
		dest.writeString(kart);
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}

	public void setTrackTimeMillis(int trackTimeMillis) {
		this.trackTimeMillis = trackTimeMillis;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setArtistViewUrl(String artistViewUrl) {
		this.artistViewUrl = artistViewUrl;
	}

	public void setDiscNumber(int discNumber) {
		this.discNumber = discNumber;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public void setArtworkUrl30(String artworkUrl30) {
		this.artworkUrl30 = artworkUrl30;
	}

	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public void setStreamable(boolean streamable) {
		isStreamable = streamable;
	}

	public void setTrackExplicitness(String trackExplicitness) {
		this.trackExplicitness = trackExplicitness;
	}

	public void setCollectionViewUrl(String collectionViewUrl) {
		this.collectionViewUrl = collectionViewUrl;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public void setCollectionPrice(double collectionPrice) {
		this.collectionPrice = collectionPrice;
	}

	public void setDiscCount(int discCount) {
		this.discCount = discCount;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	public void setTrackPrice(double trackPrice) {
		this.trackPrice = trackPrice;
	}

	public void setCollectionExplicitness(String collectionExplicitness) {
		this.collectionExplicitness = collectionExplicitness;
	}

	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}

	public void setArtworkUrl60(String artworkUrl60) {
		this.artworkUrl60 = artworkUrl60;
	}

	public void setTrackCensoredName(String trackCensoredName) {
		this.trackCensoredName = trackCensoredName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setCollectionCensoredName(String collectionCensoredName) {
		this.collectionCensoredName = collectionCensoredName;
	}

	public void setCollectionArtistName(String collectionArtistName) {
		this.collectionArtistName = collectionArtistName;
	}

	public void setCollectionArtistId(int collectionArtistId) {
		this.collectionArtistId = collectionArtistId;
	}

	public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
		this.collectionArtistViewUrl = collectionArtistViewUrl;
	}

	public void setContentAdvisoryRating(String contentAdvisoryRating) {
		this.contentAdvisoryRating = contentAdvisoryRating;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public void setTrackHdRentalPrice(double trackHdRentalPrice) {
		this.trackHdRentalPrice = trackHdRentalPrice;
	}

	public void setCollectionHdPrice(double collectionHdPrice) {
		this.collectionHdPrice = collectionHdPrice;
	}

	public void setTrackHdPrice(double trackHdPrice) {
		this.trackHdPrice = trackHdPrice;
	}

	public void setTrackRentalPrice(double trackRentalPrice) {
		this.trackRentalPrice = trackRentalPrice;
	}

	public void setHasITunesExtras(boolean hasITunesExtras) {
		this.hasITunesExtras = hasITunesExtras;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setKart(String kart) {
		this.kart = kart;
	}
}
