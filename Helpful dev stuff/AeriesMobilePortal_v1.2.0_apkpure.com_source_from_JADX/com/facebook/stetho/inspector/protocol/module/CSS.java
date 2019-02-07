package com.facebook.stetho.inspector.protocol.module;

import android.annotation.SuppressLint;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS implements ChromeDevtoolsDomain {
    private final Document mDocument;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager = new ChromePeerManager();

    private static class CSSComputedStyleProperty {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private CSSComputedStyleProperty() {
        }
    }

    private static class CSSProperty {
        @JsonProperty
        public Boolean disabled;
        @JsonProperty
        public Boolean implicit;
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty
        public Boolean parsedOk;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public String text;
        @JsonProperty(required = true)
        public String value;

        private CSSProperty() {
        }
    }

    private static class CSSRule {
        @JsonProperty
        public Origin origin;
        @JsonProperty(required = true)
        public SelectorList selectorList;
        @JsonProperty
        public CSSStyle style;
        @JsonProperty
        public String styleSheetId;

        private CSSRule() {
        }
    }

    private static class CSSStyle {
        @JsonProperty(required = true)
        public List<CSSProperty> cssProperties;
        @JsonProperty
        public String cssText;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public List<ShorthandEntry> shorthandEntries;
        @JsonProperty
        public String styleSheetId;

        private CSSStyle() {
        }
    }

    private static class GetComputedStyleForNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;

        private GetComputedStyleForNodeRequest() {
        }
    }

    private static class InheritedStyleEntry {
        @JsonProperty(required = true)
        public CSSStyle inlineStyle;
        @JsonProperty(required = true)
        public List<RuleMatch> matchedCSSRules;

        private InheritedStyleEntry() {
        }
    }

    private static class PseudoIdMatches {
        @JsonProperty(required = true)
        public List<RuleMatch> matches = new ArrayList();
        @JsonProperty(required = true)
        public int pseudoId;
    }

    private static class RuleMatch {
        @JsonProperty
        public List<Integer> matchingSelectors;
        @JsonProperty
        public CSSRule rule;

        private RuleMatch() {
        }
    }

    private static class Selector {
        @JsonProperty
        public SourceRange range;
        @JsonProperty(required = true)
        public String value;

        private Selector() {
        }
    }

    private static class SelectorList {
        @JsonProperty
        public List<Selector> selectors;
        @JsonProperty
        public String text;

        private SelectorList() {
        }
    }

    private static class ShorthandEntry {
        @JsonProperty
        public Boolean imporant;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private ShorthandEntry() {
        }
    }

    private static class SourceRange {
        @JsonProperty(required = true)
        public int endColumn;
        @JsonProperty(required = true)
        public int endLine;
        @JsonProperty(required = true)
        public int startColumn;
        @JsonProperty(required = true)
        public int startLine;

        private SourceRange() {
        }
    }

    private static class GetComputedStyleForNodeResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<CSSComputedStyleProperty> computedStyle;

        private GetComputedStyleForNodeResult() {
        }
    }

    private static class GetMatchedStylesForNodeRequest implements JsonRpcResult {
        @JsonProperty
        public Boolean excludeInherited;
        @JsonProperty
        public Boolean excludePseudo;
        @JsonProperty(required = true)
        public int nodeId;

        private GetMatchedStylesForNodeRequest() {
        }
    }

    private static class GetMatchedStylesForNodeResult implements JsonRpcResult {
        @JsonProperty
        public List<InheritedStyleEntry> inherited;
        @JsonProperty
        public List<RuleMatch> matchedCSSRules;
        @JsonProperty
        public List<PseudoIdMatches> pseudoElements;

        private GetMatchedStylesForNodeResult() {
        }
    }

    private static class SetPropertyTextRequest implements JsonRpcResult {
        @JsonProperty(required = true)
        public String styleSheetId;
        @JsonProperty(required = true)
        public String text;

        private SetPropertyTextRequest() {
        }
    }

    private static class SetPropertyTextResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public CSSStyle style;

        private SetPropertyTextResult() {
        }
    }

    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        protected synchronized void onFirstPeerRegistered() {
            CSS.this.mDocument.addRef();
        }

        protected synchronized void onLastPeerUnregistered() {
            CSS.this.mDocument.release();
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    public CSS(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        this.mPeerManager.setListener(new PeerManagerListener());
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getComputedStyleForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetComputedStyleForNodeRequest getComputedStyleForNodeRequest = (GetComputedStyleForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetComputedStyleForNodeRequest.class);
        jSONObject = new GetComputedStyleForNodeResult();
        jSONObject.computedStyle = new ArrayList();
        this.mDocument.postAndWait(new Runnable() {

            class C08611 implements ComputedStyleAccumulator {
                C08611() {
                }

                public void store(String str, String str2) {
                    CSSComputedStyleProperty cSSComputedStyleProperty = new CSSComputedStyleProperty();
                    cSSComputedStyleProperty.name = str;
                    cSSComputedStyleProperty.value = str2;
                    jSONObject.computedStyle.add(cSSComputedStyleProperty);
                }
            }

            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getComputedStyleForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Tried to get the style of an element that does not exist, using nodeid=");
                    stringBuilder.append(getComputedStyleForNodeRequest.nodeId);
                    LogUtil.m17e(stringBuilder.toString());
                    return;
                }
                CSS.this.mDocument.getElementComputedStyles(elementForNodeId, new C08611());
            }
        });
        return jSONObject;
    }

    @ChromeDevtoolsMethod
    @SuppressLint({"DefaultLocale"})
    public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetMatchedStylesForNodeRequest getMatchedStylesForNodeRequest = (GetMatchedStylesForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetMatchedStylesForNodeRequest.class);
        jSONObject = new GetMatchedStylesForNodeResult();
        jSONObject.matchedCSSRules = new ArrayList();
        jSONObject.inherited = Collections.emptyList();
        jSONObject.pseudoElements = Collections.emptyList();
        this.mDocument.postAndWait(new Runnable() {
            public void run() {
                final Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getMatchedStylesForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to get style of an element that does not exist, nodeid=");
                    stringBuilder.append(getMatchedStylesForNodeRequest.nodeId);
                    LogUtil.m29w(stringBuilder.toString());
                    return;
                }
                CSS.this.mDocument.getElementStyleRuleNames(elementForNodeId, new StyleRuleNameAccumulator() {
                    public void store(String str, boolean z) {
                        final Object arrayList = new ArrayList();
                        RuleMatch ruleMatch = new RuleMatch();
                        ruleMatch.matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
                        Selector selector = new Selector();
                        selector.value = str;
                        CSSRule cSSRule = new CSSRule();
                        cSSRule.origin = Origin.REGULAR;
                        cSSRule.selectorList = new SelectorList();
                        cSSRule.selectorList.selectors = ListUtil.newImmutableList(selector);
                        cSSRule.style = new CSSStyle();
                        cSSRule.style.cssProperties = arrayList;
                        cSSRule.style.shorthandEntries = Collections.emptyList();
                        if (z) {
                            cSSRule.style.styleSheetId = String.format("%s.%s", new Object[]{Integer.toString(getMatchedStylesForNodeRequest.nodeId), selector.value});
                        }
                        CSS.this.mDocument.getElementStyles(elementForNodeId, str, new StyleAccumulator() {
                            public void store(String str, String str2, boolean z) {
                                z = new CSSProperty();
                                z.name = str;
                                z.value = str2;
                                arrayList.add(z);
                            }
                        });
                        ruleMatch.rule = cSSRule;
                        jSONObject.matchedCSSRules.add(ruleMatch);
                    }
                });
            }
        });
        return jSONObject;
    }

    @ChromeDevtoolsMethod
    public SetPropertyTextResult setPropertyText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        String trim;
        String str;
        final JSONObject jSONObject2;
        SetPropertyTextRequest setPropertyTextRequest = (SetPropertyTextRequest) this.mObjectMapper.convertValue(jSONObject, SetPropertyTextRequest.class);
        jSONObject = setPropertyTextRequest.styleSheetId.split("\\.", 2);
        final int parseInt = Integer.parseInt(jSONObject[0]);
        final String str2 = jSONObject[1];
        if (setPropertyTextRequest.text != null) {
            if (setPropertyTextRequest.text.contains(":") != null) {
                jSONObject = setPropertyTextRequest.text.split(":", 2);
                String trim2 = jSONObject[0].trim();
                trim = StringUtil.removeAll(jSONObject[1], ';').trim();
                str = trim2;
                jSONObject = new SetPropertyTextResult();
                jSONObject.style = new CSSStyle();
                jSONObject.style.styleSheetId = setPropertyTextRequest.styleSheetId;
                jSONObject.style.cssProperties = new ArrayList();
                jSONObject.style.shorthandEntries = Collections.emptyList();
                jSONObject2 = jSONObject;
                this.mDocument.postAndWait(new Runnable() {

                    class C08641 implements StyleAccumulator {
                        C08641() {
                        }

                        public void store(String str, String str2, boolean z) {
                            z = new CSSProperty();
                            z.name = str;
                            z.value = str2;
                            jSONObject2.style.cssProperties.add(z);
                        }
                    }

                    public void run() {
                        Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(parseInt);
                        if (elementForNodeId == null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to get style of an element that does not exist, nodeid=");
                            stringBuilder.append(parseInt);
                            LogUtil.m29w(stringBuilder.toString());
                            return;
                        }
                        if (str != null) {
                            CSS.this.mDocument.setElementStyle(elementForNodeId, str2, str, trim);
                        }
                        CSS.this.mDocument.getElementStyles(elementForNodeId, str2, new C08641());
                    }
                });
                return jSONObject;
            }
        }
        str = null;
        trim = str;
        jSONObject = new SetPropertyTextResult();
        jSONObject.style = new CSSStyle();
        jSONObject.style.styleSheetId = setPropertyTextRequest.styleSheetId;
        jSONObject.style.cssProperties = new ArrayList();
        jSONObject.style.shorthandEntries = Collections.emptyList();
        jSONObject2 = jSONObject;
        this.mDocument.postAndWait(/* anonymous class already generated */);
        return jSONObject;
    }
}
