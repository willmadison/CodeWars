package com.willmadison;

import java.util.*;

public class SecretDetective {

    Map<Character, SecretNode> nodesByCharacter = new HashMap<>();

    public String recoverSecret(char[][] triplets) {
        for (char[] triplet : triplets) {
            char firstCharacter = triplet[0];
            char secondCharacter = triplet[1];
            char thirdCharacter = triplet[2];

            SecretNode firstNode = nodesByCharacter.get(firstCharacter);
            SecretNode secondNode = nodesByCharacter.get(secondCharacter);
            SecretNode thirdNode = nodesByCharacter.get(thirdCharacter);

            if (firstNode == null) {
                firstNode = new SecretNode(firstCharacter);
                nodesByCharacter.put(firstCharacter, firstNode);
            }

            if (secondNode == null) {
                secondNode = new SecretNode(secondCharacter);
                nodesByCharacter.put(secondCharacter, secondNode);
            }

            if (thirdNode == null) {
                thirdNode = new SecretNode(thirdCharacter);
                nodesByCharacter.put(thirdCharacter, thirdNode);
            }

            secondNode.addSuccessor(thirdNode);
            firstNode.addSuccessor(secondNode);
        }

        List<SecretNode> nodes = new ArrayList<>(nodesByCharacter.values());

        Collections.sort(nodes, (firstNode, secondNode) -> firstNode.getPredecessors().size() - secondNode.getPredecessors().size());

        return SecretNode.fromCollection(nodes);
    }

    private static class SecretNode {
        private Character value;

        Collection<SecretNode> predecessors = new HashSet<>();

        Collection<SecretNode> successors = new HashSet<>();

        public SecretNode(Character value) {
            this.value = value;
        }

        public void addSuccessor(SecretNode s) {
            if (!successors.contains(s)) {
                successors.add(s);
                s.addPredecessor(this);
                s.getSuccessors().forEach(this::addSuccessor);
            }
        }

        public void addPredecessor(SecretNode s) {
            if (!predecessors.contains(s)) {
                predecessors.add(s);
                s.addSuccessor(this);
                s.getPredecessors().forEach(this::addPredecessor);
            }
        }

        public Character getValue() {
            return value;
        }

        public Collection<SecretNode> getPredecessors() {
            return predecessors;
        }

        public Collection<SecretNode> getSuccessors() {
            return successors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SecretNode that = (SecretNode) o;

            return value.equals(that.value);

        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        public static String fromCollection(Collection<SecretNode> nodes) {
            StringBuilder sb = new StringBuilder();

            for (SecretNode node : nodes) {
                sb.append(node.getValue());
            }

            return sb.toString();
        }
    }

    public static void main(String args[]) {
        SecretDetective detective = new SecretDetective();
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };

        System.out.println("whatisup" + " = " + detective.recoverSecret(triplets) + "?");
    }
}
