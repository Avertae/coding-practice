class Solution {

    Character identifyEntity(String entity) {
        switch (entity) {
            case "quot": return '"';
            case "apos": return '\'';
            case "amp": return '&';
            case "gt": return '>';
            case "lt": return '<';
            case "frasl": return '/';
            default: return null;
        }
    }

    public String entityParser(String text) {
        StringBuilder result = new StringBuilder();
        int pos = 0, search_pos = 0, n = text.length();
        while (true) {
            int amp = text.indexOf('&', search_pos);
            if (amp < 0) {
                result.append(text.substring(pos));
                break;
            }
            String entityCandidate = text.substring(amp, Math.min(n, amp+7));
            int semicolonPos = entityCandidate.indexOf(';');
            //dbg(amp, semicolonPos);
            if (semicolonPos < 0) {
                search_pos = amp + 1;
                continue;
            }
            Character entity = identifyEntity(entityCandidate.substring(1, semicolonPos));
            //dbg(entity, entityCandidate.substring(0, semicolonPos));
            if (entity != null) {
                result
                    .append(text.substring(pos, amp))
                    .append(entity);
                search_pos = amp + semicolonPos + 1;
                pos = search_pos;
            } else 
               search_pos++; 
        }

        return result.toString();
    }

}