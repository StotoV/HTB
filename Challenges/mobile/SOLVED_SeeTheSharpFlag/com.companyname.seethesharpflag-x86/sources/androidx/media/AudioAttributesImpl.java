package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;
/* loaded from: classes.dex */
public interface AudioAttributesImpl extends VersionedParcelable {

    /* loaded from: classes.dex */
    public interface Builder {
        AudioAttributesImpl build();

        /* renamed from: setContentType */
        Builder mo103setContentType(int i);

        /* renamed from: setFlags */
        Builder mo104setFlags(int i);

        /* renamed from: setLegacyStreamType */
        Builder mo105setLegacyStreamType(int i);

        /* renamed from: setUsage */
        Builder mo106setUsage(int i);
    }

    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();
}
