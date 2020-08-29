package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0793a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.internal.ir */
public final class C1088ir extends C0792fb implements SafeParcelable, Person {
    public static final C1099is CREATOR = new C1099is();

    /* renamed from: RL */
    private static final HashMap<String, C0793a<?, ?>> f2978RL = new HashMap<>();

    /* renamed from: FE */
    private String f2979FE;

    /* renamed from: RM */
    private final Set<Integer> f2980RM;

    /* renamed from: SK */
    private String f2981SK;

    /* renamed from: SL */
    private C1089a f2982SL;

    /* renamed from: SM */
    private String f2983SM;

    /* renamed from: SN */
    private String f2984SN;

    /* renamed from: SO */
    private int f2985SO;

    /* renamed from: SP */
    private C1090b f2986SP;

    /* renamed from: SQ */
    private String f2987SQ;

    /* renamed from: SR */
    private C1093c f2988SR;

    /* renamed from: SS */
    private boolean f2989SS;

    /* renamed from: ST */
    private String f2990ST;

    /* renamed from: SU */
    private C1094d f2991SU;

    /* renamed from: SV */
    private String f2992SV;

    /* renamed from: SW */
    private int f2993SW;

    /* renamed from: SX */
    private List<C1096f> f2994SX;

    /* renamed from: SY */
    private List<C1097g> f2995SY;

    /* renamed from: SZ */
    private int f2996SZ;

    /* renamed from: Ta */
    private int f2997Ta;

    /* renamed from: Tb */
    private String f2998Tb;

    /* renamed from: Tc */
    private List<C1098h> f2999Tc;

    /* renamed from: Td */
    private boolean f3000Td;

    /* renamed from: lu */
    private int f3001lu;

    /* renamed from: pS */
    private String f3002pS;

    /* renamed from: uS */
    private String f3003uS;

    /* renamed from: wj */
    private final int f3004wj;

    /* renamed from: com.google.android.gms.internal.ir$a */
    public static final class C1089a extends C0792fb implements SafeParcelable, AgeRange {
        public static final C1100it CREATOR = new C1100it();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3005RL = new HashMap<>();

        /* renamed from: RM */
        private final Set<Integer> f3006RM;

        /* renamed from: Te */
        private int f3007Te;

        /* renamed from: Tf */
        private int f3008Tf;

        /* renamed from: wj */
        private final int f3009wj;

        static {
            f3005RL.put("max", C0793a.m2040g("max", 2));
            f3005RL.put("min", C0793a.m2040g("min", 3));
        }

        public C1089a() {
            this.f3009wj = 1;
            this.f3006RM = new HashSet();
        }

        C1089a(Set<Integer> set, int i, int i2, int i3) {
            this.f3006RM = set;
            this.f3009wj = i;
            this.f3007Te = i2;
            this.f3008Tf = i3;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3006RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return Integer.valueOf(this.f3007Te);
                case 3:
                    return Integer.valueOf(this.f3008Tf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1100it itVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3005RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1089a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1089a aVar = (C1089a) obj;
            for (C0793a aVar2 : f3005RL.values()) {
                if (mo5164a(aVar2)) {
                    if (!aVar.mo5164a(aVar2)) {
                        return false;
                    }
                    if (!mo5169b(aVar2).equals(aVar.mo5169b(aVar2))) {
                        return false;
                    }
                } else if (aVar.mo5164a(aVar2)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.f3007Te;
        }

        public int getMin() {
            return this.f3008Tf;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3009wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6119hB() {
            return this.f3006RM;
        }

        public boolean hasMax() {
            return this.f3006RM.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.f3006RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3005RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: ie */
        public C1089a freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1100it itVar = CREATOR;
            C1100it.m3274a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$b */
    public static final class C1090b extends C0792fb implements SafeParcelable, Cover {
        public static final C1101iu CREATOR = new C1101iu();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3010RL = new HashMap<>();

        /* renamed from: RM */
        private final Set<Integer> f3011RM;

        /* renamed from: Tg */
        private C1091a f3012Tg;

        /* renamed from: Th */
        private C1092b f3013Th;

        /* renamed from: Ti */
        private int f3014Ti;

        /* renamed from: wj */
        private final int f3015wj;

        /* renamed from: com.google.android.gms.internal.ir$b$a */
        public static final class C1091a extends C0792fb implements SafeParcelable, CoverInfo {
            public static final C1102iv CREATOR = new C1102iv();

            /* renamed from: RL */
            private static final HashMap<String, C0793a<?, ?>> f3016RL = new HashMap<>();

            /* renamed from: RM */
            private final Set<Integer> f3017RM;

            /* renamed from: Tj */
            private int f3018Tj;

            /* renamed from: Tk */
            private int f3019Tk;

            /* renamed from: wj */
            private final int f3020wj;

            static {
                f3016RL.put("leftImageOffset", C0793a.m2040g("leftImageOffset", 2));
                f3016RL.put("topImageOffset", C0793a.m2040g("topImageOffset", 3));
            }

            public C1091a() {
                this.f3020wj = 1;
                this.f3017RM = new HashSet();
            }

            C1091a(Set<Integer> set, int i, int i2, int i3) {
                this.f3017RM = set;
                this.f3020wj = i;
                this.f3018Tj = i2;
                this.f3019Tk = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo5164a(C0793a aVar) {
                return this.f3017RM.contains(Integer.valueOf(aVar.mo5182eu()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: ak */
            public Object mo5165ak(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: al */
            public boolean mo5166al(String str) {
                return false;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo5169b(C0793a aVar) {
                switch (aVar.mo5182eu()) {
                    case 2:
                        return Integer.valueOf(this.f3018Tj);
                    case 3:
                        return Integer.valueOf(this.f3019Tk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
                }
            }

            public int describeContents() {
                C1102iv ivVar = CREATOR;
                return 0;
            }

            /* renamed from: en */
            public HashMap<String, C0793a<?, ?>> mo5170en() {
                return f3016RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1091a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1091a aVar = (C1091a) obj;
                for (C0793a aVar2 : f3016RL.values()) {
                    if (mo5164a(aVar2)) {
                        if (!aVar.mo5164a(aVar2)) {
                            return false;
                        }
                        if (!mo5169b(aVar2).equals(aVar.mo5169b(aVar2))) {
                            return false;
                        }
                    } else if (aVar.mo5164a(aVar2)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.f3018Tj;
            }

            public int getTopImageOffset() {
                return this.f3019Tk;
            }

            /* access modifiers changed from: 0000 */
            public int getVersionCode() {
                return this.f3020wj;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: hB */
            public Set<Integer> mo6145hB() {
                return this.f3017RM;
            }

            public boolean hasLeftImageOffset() {
                return this.f3017RM.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.f3017RM.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                Iterator it = f3016RL.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0793a aVar = (C0793a) it.next();
                    if (mo5164a(aVar)) {
                        i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                    } else {
                        i = i2;
                    }
                }
            }

            /* renamed from: ii */
            public C1091a freeze() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                C1102iv ivVar = CREATOR;
                C1102iv.m3280a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ir$b$b */
        public static final class C1092b extends C0792fb implements SafeParcelable, CoverPhoto {
            public static final C1103iw CREATOR = new C1103iw();

            /* renamed from: RL */
            private static final HashMap<String, C0793a<?, ?>> f3021RL = new HashMap<>();

            /* renamed from: RM */
            private final Set<Integer> f3022RM;

            /* renamed from: pS */
            private String f3023pS;

            /* renamed from: v */
            private int f3024v;

            /* renamed from: w */
            private int f3025w;

            /* renamed from: wj */
            private final int f3026wj;

            static {
                f3021RL.put("height", C0793a.m2040g("height", 2));
                f3021RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0793a.m2043j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                f3021RL.put("width", C0793a.m2040g("width", 4));
            }

            public C1092b() {
                this.f3026wj = 1;
                this.f3022RM = new HashSet();
            }

            C1092b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.f3022RM = set;
                this.f3026wj = i;
                this.f3024v = i2;
                this.f3023pS = str;
                this.f3025w = i3;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo5164a(C0793a aVar) {
                return this.f3022RM.contains(Integer.valueOf(aVar.mo5182eu()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: ak */
            public Object mo5165ak(String str) {
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: al */
            public boolean mo5166al(String str) {
                return false;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Object mo5169b(C0793a aVar) {
                switch (aVar.mo5182eu()) {
                    case 2:
                        return Integer.valueOf(this.f3024v);
                    case 3:
                        return this.f3023pS;
                    case 4:
                        return Integer.valueOf(this.f3025w);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
                }
            }

            public int describeContents() {
                C1103iw iwVar = CREATOR;
                return 0;
            }

            /* renamed from: en */
            public HashMap<String, C0793a<?, ?>> mo5170en() {
                return f3021RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1092b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1092b bVar = (C1092b) obj;
                for (C0793a aVar : f3021RL.values()) {
                    if (mo5164a(aVar)) {
                        if (!bVar.mo5164a(aVar)) {
                            return false;
                        }
                        if (!mo5169b(aVar).equals(bVar.mo5169b(aVar))) {
                            return false;
                        }
                    } else if (bVar.mo5164a(aVar)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.f3024v;
            }

            public String getUrl() {
                return this.f3023pS;
            }

            /* access modifiers changed from: 0000 */
            public int getVersionCode() {
                return this.f3026wj;
            }

            public int getWidth() {
                return this.f3025w;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: hB */
            public Set<Integer> mo6157hB() {
                return this.f3022RM;
            }

            public boolean hasHeight() {
                return this.f3022RM.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.f3022RM.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.f3022RM.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                Iterator it = f3021RL.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    C0793a aVar = (C0793a) it.next();
                    if (mo5164a(aVar)) {
                        i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                    } else {
                        i = i2;
                    }
                }
            }

            /* renamed from: ij */
            public C1092b freeze() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                C1103iw iwVar = CREATOR;
                C1103iw.m3283a(this, out, flags);
            }
        }

        static {
            f3010RL.put("coverInfo", C0793a.m2037a("coverInfo", 2, C1091a.class));
            f3010RL.put("coverPhoto", C0793a.m2037a("coverPhoto", 3, C1092b.class));
            f3010RL.put("layout", C0793a.m2036a("layout", 4, new C0773ey().mo5147f("banner", 0), false));
        }

        public C1090b() {
            this.f3015wj = 1;
            this.f3011RM = new HashSet();
        }

        C1090b(Set<Integer> set, int i, C1091a aVar, C1092b bVar, int i2) {
            this.f3011RM = set;
            this.f3015wj = i;
            this.f3012Tg = aVar;
            this.f3013Th = bVar;
            this.f3014Ti = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3011RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return this.f3012Tg;
                case 3:
                    return this.f3013Th;
                case 4:
                    return Integer.valueOf(this.f3014Ti);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1101iu iuVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3010RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1090b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1090b bVar = (C1090b) obj;
            for (C0793a aVar : f3010RL.values()) {
                if (mo5164a(aVar)) {
                    if (!bVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(bVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (bVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public CoverInfo getCoverInfo() {
            return this.f3012Tg;
        }

        public CoverPhoto getCoverPhoto() {
            return this.f3013Th;
        }

        public int getLayout() {
            return this.f3014Ti;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3015wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6131hB() {
            return this.f3011RM;
        }

        public boolean hasCoverInfo() {
            return this.f3011RM.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.f3011RM.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.f3011RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3010RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: if */
        public C1091a mo6136if() {
            return this.f3012Tg;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ig */
        public C1092b mo6137ig() {
            return this.f3013Th;
        }

        /* renamed from: ih */
        public C1090b freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1101iu iuVar = CREATOR;
            C1101iu.m3277a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$c */
    public static final class C1093c extends C0792fb implements SafeParcelable, Image {
        public static final C1104ix CREATOR = new C1104ix();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3027RL = new HashMap<>();

        /* renamed from: RM */
        private final Set<Integer> f3028RM;

        /* renamed from: pS */
        private String f3029pS;

        /* renamed from: wj */
        private final int f3030wj;

        static {
            f3027RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0793a.m2043j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1093c() {
            this.f3030wj = 1;
            this.f3028RM = new HashSet();
        }

        public C1093c(String str) {
            this.f3028RM = new HashSet();
            this.f3030wj = 1;
            this.f3029pS = str;
            this.f3028RM.add(Integer.valueOf(2));
        }

        C1093c(Set<Integer> set, int i, String str) {
            this.f3028RM = set;
            this.f3030wj = i;
            this.f3029pS = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3028RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return this.f3029pS;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1104ix ixVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3027RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1093c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1093c cVar = (C1093c) obj;
            for (C0793a aVar : f3027RL.values()) {
                if (mo5164a(aVar)) {
                    if (!cVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(cVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (cVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.f3029pS;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3030wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6168hB() {
            return this.f3028RM;
        }

        public boolean hasUrl() {
            return this.f3028RM.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3027RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: ik */
        public C1093c freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1104ix ixVar = CREATOR;
            C1104ix.m3286a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$d */
    public static final class C1094d extends C0792fb implements SafeParcelable, Name {
        public static final C1105iy CREATOR = new C1105iy();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3031RL = new HashMap<>();

        /* renamed from: RM */
        private final Set<Integer> f3032RM;

        /* renamed from: Sk */
        private String f3033Sk;

        /* renamed from: Sn */
        private String f3034Sn;

        /* renamed from: Tl */
        private String f3035Tl;

        /* renamed from: Tm */
        private String f3036Tm;

        /* renamed from: Tn */
        private String f3037Tn;

        /* renamed from: To */
        private String f3038To;

        /* renamed from: wj */
        private final int f3039wj;

        static {
            f3031RL.put("familyName", C0793a.m2043j("familyName", 2));
            f3031RL.put("formatted", C0793a.m2043j("formatted", 3));
            f3031RL.put("givenName", C0793a.m2043j("givenName", 4));
            f3031RL.put("honorificPrefix", C0793a.m2043j("honorificPrefix", 5));
            f3031RL.put("honorificSuffix", C0793a.m2043j("honorificSuffix", 6));
            f3031RL.put("middleName", C0793a.m2043j("middleName", 7));
        }

        public C1094d() {
            this.f3039wj = 1;
            this.f3032RM = new HashSet();
        }

        C1094d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f3032RM = set;
            this.f3039wj = i;
            this.f3033Sk = str;
            this.f3035Tl = str2;
            this.f3034Sn = str3;
            this.f3036Tm = str4;
            this.f3037Tn = str5;
            this.f3038To = str6;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3032RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return this.f3033Sk;
                case 3:
                    return this.f3035Tl;
                case 4:
                    return this.f3034Sn;
                case 5:
                    return this.f3036Tm;
                case 6:
                    return this.f3037Tn;
                case 7:
                    return this.f3038To;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1105iy iyVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3031RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1094d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1094d dVar = (C1094d) obj;
            for (C0793a aVar : f3031RL.values()) {
                if (mo5164a(aVar)) {
                    if (!dVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(dVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (dVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.f3033Sk;
        }

        public String getFormatted() {
            return this.f3035Tl;
        }

        public String getGivenName() {
            return this.f3034Sn;
        }

        public String getHonorificPrefix() {
            return this.f3036Tm;
        }

        public String getHonorificSuffix() {
            return this.f3037Tn;
        }

        public String getMiddleName() {
            return this.f3038To;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3039wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6182hB() {
            return this.f3032RM;
        }

        public boolean hasFamilyName() {
            return this.f3032RM.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.f3032RM.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.f3032RM.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.f3032RM.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.f3032RM.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.f3032RM.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3031RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: il */
        public C1094d freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1105iy iyVar = CREATOR;
            C1105iy.m3289a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$e */
    public static class C1095e {
        /* renamed from: aT */
        public static int m3248aT(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$f */
    public static final class C1096f extends C0792fb implements SafeParcelable, Organizations {
        public static final C1106iz CREATOR = new C1106iz();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3040RL = new HashMap<>();

        /* renamed from: AI */
        private int f3041AI;

        /* renamed from: CX */
        private String f3042CX;

        /* renamed from: FH */
        private String f3043FH;

        /* renamed from: RM */
        private final Set<Integer> f3044RM;

        /* renamed from: Sj */
        private String f3045Sj;

        /* renamed from: Sz */
        private String f3046Sz;

        /* renamed from: Tp */
        private String f3047Tp;

        /* renamed from: Tq */
        private String f3048Tq;

        /* renamed from: Tr */
        private boolean f3049Tr;
        private String mName;

        /* renamed from: wj */
        private final int f3050wj;

        static {
            f3040RL.put("department", C0793a.m2043j("department", 2));
            f3040RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0793a.m2043j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            f3040RL.put("endDate", C0793a.m2043j("endDate", 4));
            f3040RL.put("location", C0793a.m2043j("location", 5));
            f3040RL.put(IDemoChart.NAME, C0793a.m2043j(IDemoChart.NAME, 6));
            f3040RL.put("primary", C0793a.m2042i("primary", 7));
            f3040RL.put("startDate", C0793a.m2043j("startDate", 8));
            f3040RL.put("title", C0793a.m2043j("title", 9));
            f3040RL.put("type", C0793a.m2036a("type", 10, new C0773ey().mo5147f("work", 0).mo5147f("school", 1), false));
        }

        public C1096f() {
            this.f3050wj = 1;
            this.f3044RM = new HashSet();
        }

        C1096f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.f3044RM = set;
            this.f3050wj = i;
            this.f3047Tp = str;
            this.f3043FH = str2;
            this.f3045Sj = str3;
            this.f3048Tq = str4;
            this.mName = str5;
            this.f3049Tr = z;
            this.f3046Sz = str6;
            this.f3042CX = str7;
            this.f3041AI = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3044RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return this.f3047Tp;
                case 3:
                    return this.f3043FH;
                case 4:
                    return this.f3045Sj;
                case 5:
                    return this.f3048Tq;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.f3049Tr);
                case 8:
                    return this.f3046Sz;
                case 9:
                    return this.f3042CX;
                case 10:
                    return Integer.valueOf(this.f3041AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1106iz izVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3040RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1096f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1096f fVar = (C1096f) obj;
            for (C0793a aVar : f3040RL.values()) {
                if (mo5164a(aVar)) {
                    if (!fVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(fVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (fVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.f3047Tp;
        }

        public String getDescription() {
            return this.f3043FH;
        }

        public String getEndDate() {
            return this.f3045Sj;
        }

        public String getLocation() {
            return this.f3048Tq;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.f3046Sz;
        }

        public String getTitle() {
            return this.f3042CX;
        }

        public int getType() {
            return this.f3041AI;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3050wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6203hB() {
            return this.f3044RM;
        }

        public boolean hasDepartment() {
            return this.f3044RM.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.f3044RM.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.f3044RM.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.f3044RM.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.f3044RM.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.f3044RM.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.f3044RM.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.f3044RM.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.f3044RM.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3040RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: im */
        public C1096f freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f3049Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1106iz izVar = CREATOR;
            C1106iz.m3292a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$g */
    public static final class C1097g extends C0792fb implements SafeParcelable, PlacesLived {
        public static final C1109ja CREATOR = new C1109ja();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3051RL = new HashMap<>();

        /* renamed from: RM */
        private final Set<Integer> f3052RM;

        /* renamed from: Tr */
        private boolean f3053Tr;
        private String mValue;

        /* renamed from: wj */
        private final int f3054wj;

        static {
            f3051RL.put("primary", C0793a.m2042i("primary", 2));
            f3051RL.put("value", C0793a.m2043j("value", 3));
        }

        public C1097g() {
            this.f3054wj = 1;
            this.f3052RM = new HashSet();
        }

        C1097g(Set<Integer> set, int i, boolean z, String str) {
            this.f3052RM = set;
            this.f3054wj = i;
            this.f3053Tr = z;
            this.mValue = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3052RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 2:
                    return Boolean.valueOf(this.f3053Tr);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1109ja jaVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3051RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1097g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1097g gVar = (C1097g) obj;
            for (C0793a aVar : f3051RL.values()) {
                if (mo5164a(aVar)) {
                    if (!gVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(gVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (gVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3054wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6221hB() {
            return this.f3052RM;
        }

        public boolean hasPrimary() {
            return this.f3052RM.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.f3052RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3051RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        /* renamed from: in */
        public C1097g freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.f3053Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1109ja jaVar = CREATOR;
            C1109ja.m3307a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir$h */
    public static final class C1098h extends C0792fb implements SafeParcelable, Urls {
        public static final C1110jb CREATOR = new C1110jb();

        /* renamed from: RL */
        private static final HashMap<String, C0793a<?, ?>> f3055RL = new HashMap<>();

        /* renamed from: AI */
        private int f3056AI;

        /* renamed from: RM */
        private final Set<Integer> f3057RM;

        /* renamed from: Ts */
        private String f3058Ts;

        /* renamed from: Tt */
        private final int f3059Tt;
        private String mValue;

        /* renamed from: wj */
        private final int f3060wj;

        static {
            f3055RL.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0793a.m2043j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            f3055RL.put("type", C0793a.m2036a("type", 6, new C0773ey().mo5147f("home", 0).mo5147f("work", 1).mo5147f("blog", 2).mo5147f(Scopes.PROFILE, 3).mo5147f("other", 4).mo5147f("otherProfile", 5).mo5147f("contributor", 6).mo5147f("website", 7), false));
            f3055RL.put("value", C0793a.m2043j("value", 4));
        }

        public C1098h() {
            this.f3059Tt = 4;
            this.f3060wj = 2;
            this.f3057RM = new HashSet();
        }

        C1098h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.f3059Tt = 4;
            this.f3057RM = set;
            this.f3060wj = i;
            this.f3058Ts = str;
            this.f3056AI = i2;
            this.mValue = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo5164a(C0793a aVar) {
            return this.f3057RM.contains(Integer.valueOf(aVar.mo5182eu()));
        }

        /* access modifiers changed from: protected */
        /* renamed from: ak */
        public Object mo5165ak(String str) {
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: al */
        public boolean mo5166al(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo5169b(C0793a aVar) {
            switch (aVar.mo5182eu()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.f3058Ts;
                case 6:
                    return Integer.valueOf(this.f3056AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
            }
        }

        public int describeContents() {
            C1110jb jbVar = CREATOR;
            return 0;
        }

        /* renamed from: en */
        public HashMap<String, C0793a<?, ?>> mo5170en() {
            return f3055RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1098h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1098h hVar = (C1098h) obj;
            for (C0793a aVar : f3055RL.values()) {
                if (mo5164a(aVar)) {
                    if (!hVar.mo5164a(aVar)) {
                        return false;
                    }
                    if (!mo5169b(aVar).equals(hVar.mo5169b(aVar))) {
                        return false;
                    }
                } else if (hVar.mo5164a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.f3058Ts;
        }

        public int getType() {
            return this.f3056AI;
        }

        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: 0000 */
        public int getVersionCode() {
            return this.f3060wj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: hB */
        public Set<Integer> mo6234hB() {
            return this.f3057RM;
        }

        public boolean hasLabel() {
            return this.f3057RM.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.f3057RM.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.f3057RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = f3055RL.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                C0793a aVar = (C0793a) it.next();
                if (mo5164a(aVar)) {
                    i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
                } else {
                    i = i2;
                }
            }
        }

        @Deprecated
        /* renamed from: io */
        public int mo6239io() {
            return 4;
        }

        /* renamed from: ip */
        public C1098h freeze() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1110jb jbVar = CREATOR;
            C1110jb.m3310a(this, out, flags);
        }
    }

    static {
        f2978RL.put("aboutMe", C0793a.m2043j("aboutMe", 2));
        f2978RL.put("ageRange", C0793a.m2037a("ageRange", 3, C1089a.class));
        f2978RL.put("birthday", C0793a.m2043j("birthday", 4));
        f2978RL.put("braggingRights", C0793a.m2043j("braggingRights", 5));
        f2978RL.put("circledByCount", C0793a.m2040g("circledByCount", 6));
        f2978RL.put("cover", C0793a.m2037a("cover", 7, C1090b.class));
        f2978RL.put("currentLocation", C0793a.m2043j("currentLocation", 8));
        f2978RL.put("displayName", C0793a.m2043j("displayName", 9));
        f2978RL.put("gender", C0793a.m2036a("gender", 12, new C0773ey().mo5147f("male", 0).mo5147f("female", 1).mo5147f("other", 2), false));
        f2978RL.put("id", C0793a.m2043j("id", 14));
        f2978RL.put("image", C0793a.m2037a("image", 15, C1093c.class));
        f2978RL.put("isPlusUser", C0793a.m2042i("isPlusUser", 16));
        f2978RL.put("language", C0793a.m2043j("language", 18));
        f2978RL.put(IDemoChart.NAME, C0793a.m2037a(IDemoChart.NAME, 19, C1094d.class));
        f2978RL.put("nickname", C0793a.m2043j("nickname", 20));
        f2978RL.put("objectType", C0793a.m2036a("objectType", 21, new C0773ey().mo5147f("person", 0).mo5147f("page", 1), false));
        f2978RL.put("organizations", C0793a.m2038b("organizations", 22, C1096f.class));
        f2978RL.put("placesLived", C0793a.m2038b("placesLived", 23, C1097g.class));
        f2978RL.put("plusOneCount", C0793a.m2040g("plusOneCount", 24));
        f2978RL.put("relationshipStatus", C0793a.m2036a("relationshipStatus", 25, new C0773ey().mo5147f("single", 0).mo5147f("in_a_relationship", 1).mo5147f("engaged", 2).mo5147f("married", 3).mo5147f("its_complicated", 4).mo5147f("open_relationship", 5).mo5147f("widowed", 6).mo5147f("in_domestic_partnership", 7).mo5147f("in_civil_union", 8), false));
        f2978RL.put("tagline", C0793a.m2043j("tagline", 26));
        f2978RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0793a.m2043j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        f2978RL.put("urls", C0793a.m2038b("urls", 28, C1098h.class));
        f2978RL.put("verified", C0793a.m2042i("verified", 29));
    }

    public C1088ir() {
        this.f3004wj = 2;
        this.f2980RM = new HashSet();
    }

    public C1088ir(String str, String str2, C1093c cVar, int i, String str3) {
        this.f3004wj = 2;
        this.f2980RM = new HashSet();
        this.f2979FE = str;
        this.f2980RM.add(Integer.valueOf(9));
        this.f3003uS = str2;
        this.f2980RM.add(Integer.valueOf(14));
        this.f2988SR = cVar;
        this.f2980RM.add(Integer.valueOf(15));
        this.f2993SW = i;
        this.f2980RM.add(Integer.valueOf(21));
        this.f3002pS = str3;
        this.f2980RM.add(Integer.valueOf(27));
    }

    C1088ir(Set<Integer> set, int i, String str, C1089a aVar, String str2, String str3, int i2, C1090b bVar, String str4, String str5, int i3, String str6, C1093c cVar, boolean z, String str7, C1094d dVar, String str8, int i4, List<C1096f> list, List<C1097g> list2, int i5, int i6, String str9, String str10, List<C1098h> list3, boolean z2) {
        this.f2980RM = set;
        this.f3004wj = i;
        this.f2981SK = str;
        this.f2982SL = aVar;
        this.f2983SM = str2;
        this.f2984SN = str3;
        this.f2985SO = i2;
        this.f2986SP = bVar;
        this.f2987SQ = str4;
        this.f2979FE = str5;
        this.f3001lu = i3;
        this.f3003uS = str6;
        this.f2988SR = cVar;
        this.f2989SS = z;
        this.f2990ST = str7;
        this.f2991SU = dVar;
        this.f2992SV = str8;
        this.f2993SW = i4;
        this.f2994SX = list;
        this.f2995SY = list2;
        this.f2996SZ = i5;
        this.f2997Ta = i6;
        this.f2998Tb = str9;
        this.f3002pS = str10;
        this.f2999Tc = list3;
        this.f3000Td = z2;
    }

    /* renamed from: i */
    public static C1088ir m3189i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C1088ir aI = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return aI;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5164a(C0793a aVar) {
        return this.f2980RM.contains(Integer.valueOf(aVar.mo5182eu()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public Object mo5165ak(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public boolean mo5166al(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo5169b(C0793a aVar) {
        switch (aVar.mo5182eu()) {
            case 2:
                return this.f2981SK;
            case 3:
                return this.f2982SL;
            case 4:
                return this.f2983SM;
            case 5:
                return this.f2984SN;
            case 6:
                return Integer.valueOf(this.f2985SO);
            case 7:
                return this.f2986SP;
            case 8:
                return this.f2987SQ;
            case 9:
                return this.f2979FE;
            case 12:
                return Integer.valueOf(this.f3001lu);
            case 14:
                return this.f3003uS;
            case 15:
                return this.f2988SR;
            case 16:
                return Boolean.valueOf(this.f2989SS);
            case 18:
                return this.f2990ST;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.f2991SU;
            case Parameter.RETRY_TIMES /*20*/:
                return this.f2992SV;
            case 21:
                return Integer.valueOf(this.f2993SW);
            case 22:
                return this.f2994SX;
            case 23:
                return this.f2995SY;
            case 24:
                return Integer.valueOf(this.f2996SZ);
            case 25:
                return Integer.valueOf(this.f2997Ta);
            case 26:
                return this.f2998Tb;
            case 27:
                return this.f3002pS;
            case 28:
                return this.f2999Tc;
            case 29:
                return Boolean.valueOf(this.f3000Td);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
        }
    }

    public int describeContents() {
        C1099is isVar = CREATOR;
        return 0;
    }

    /* renamed from: en */
    public HashMap<String, C0793a<?, ?>> mo5170en() {
        return f2978RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1088ir)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1088ir irVar = (C1088ir) obj;
        for (C0793a aVar : f2978RL.values()) {
            if (mo5164a(aVar)) {
                if (!irVar.mo5164a(aVar)) {
                    return false;
                }
                if (!mo5169b(aVar).equals(irVar.mo5169b(aVar))) {
                    return false;
                }
            } else if (irVar.mo5164a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.f2981SK;
    }

    public AgeRange getAgeRange() {
        return this.f2982SL;
    }

    public String getBirthday() {
        return this.f2983SM;
    }

    public String getBraggingRights() {
        return this.f2984SN;
    }

    public int getCircledByCount() {
        return this.f2985SO;
    }

    public Cover getCover() {
        return this.f2986SP;
    }

    public String getCurrentLocation() {
        return this.f2987SQ;
    }

    public String getDisplayName() {
        return this.f2979FE;
    }

    public int getGender() {
        return this.f3001lu;
    }

    public String getId() {
        return this.f3003uS;
    }

    public Image getImage() {
        return this.f2988SR;
    }

    public String getLanguage() {
        return this.f2990ST;
    }

    public Name getName() {
        return this.f2991SU;
    }

    public String getNickname() {
        return this.f2992SV;
    }

    public int getObjectType() {
        return this.f2993SW;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.f2994SX;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.f2995SY;
    }

    public int getPlusOneCount() {
        return this.f2996SZ;
    }

    public int getRelationshipStatus() {
        return this.f2997Ta;
    }

    public String getTagline() {
        return this.f2998Tb;
    }

    public String getUrl() {
        return this.f3002pS;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.f2999Tc;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3004wj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hB */
    public Set<Integer> mo6077hB() {
        return this.f2980RM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hW */
    public C1089a mo6078hW() {
        return this.f2982SL;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hX */
    public C1090b mo6079hX() {
        return this.f2986SP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hY */
    public C1093c mo6080hY() {
        return this.f2988SR;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hZ */
    public C1094d mo6081hZ() {
        return this.f2991SU;
    }

    public boolean hasAboutMe() {
        return this.f2980RM.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.f2980RM.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.f2980RM.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.f2980RM.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.f2980RM.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.f2980RM.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.f2980RM.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.f2980RM.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.f2980RM.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.f2980RM.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.f2980RM.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.f2980RM.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.f2980RM.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.f2980RM.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.f2980RM.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.f2980RM.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.f2980RM.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.f2980RM.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.f2980RM.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.f2980RM.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.f2980RM.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.f2980RM.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.f2980RM.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.f2980RM.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = f2978RL.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0793a aVar = (C0793a) it.next();
            if (mo5164a(aVar)) {
                i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
            } else {
                i = i2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ia */
    public List<C1096f> mo6107ia() {
        return this.f2994SX;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public List<C1097g> mo6108ib() {
        return this.f2995SY;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ic */
    public List<C1098h> mo6109ic() {
        return this.f2999Tc;
    }

    /* renamed from: id */
    public C1088ir freeze() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.f2989SS;
    }

    public boolean isVerified() {
        return this.f3000Td;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1099is isVar = CREATOR;
        C1099is.m3271a(this, out, flags);
    }
}
