package bolts;
/* loaded from: classes.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    /* renamed from: then */
    TContinuationResult mo154then(Task<TTaskResult> task) throws Exception;
}
