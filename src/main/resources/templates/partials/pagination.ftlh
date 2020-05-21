<#import "/spring.ftl" as spring>
<div>
        <#if hasPrev>
                <a id="loadPrev" href="${prevPageLink!''}"> &lt;&lt;&lt;<@spring.message "Previous-page"/></a>
        <#else>
                <span id="loadPrev"><@spring.message "Previous-page"/></span>
        </#if>

        <#if hasNext>
                <a id="loadNext" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!5}"><@spring.message "Next-page"/>&gt;&gt;&gt;</a>
        <#else>
                <span><@spring.message "Next-page"/></span>
        </#if>
</div>