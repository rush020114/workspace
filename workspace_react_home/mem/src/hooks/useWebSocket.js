import { useEffect, useRef } from 'react';
import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

// userId: 사용자 ID, isAdmin: 관리자 여부
export const useWebSocket = (userId, isAdmin, onNotification) => {
  
  // WebSocket 클라이언트를 저장할 ref (리렌더링 시에도 유지)
  // clientRef = 로그아웃 시 이전 연결 끊기 위한 저장소
  const clientRef = useRef(null);
  const nav = useNavigate();

  // userId나 isAdmin이 변경될 때마다 실행
  useEffect(() => {

    // 로그인하지 않았으면 (userId도 없고 관리자도 아니면)
    if (!userId && !isAdmin) {
      console.log('로그인 필요');
      return;  // 여기서 종료, WebSocket 연결 안 함
    }

    // WebSocket 클라이언트 생성
    const client = new Client({
      
      // SockJS로 WebSocket 연결 (fallback 지원)
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
      
      // 연결 성공 시 실행되는 함수
      onConnect: () => {
        console.log('WebSocket 연결됨');

        // 관리자면
        if (isAdmin) {
          // '/topic/admin' 주소 구독 (관리자 알림용)
          // message매개변수는 서버에서 보낸 데이터
          client.subscribe('/topic/admin', (message) => {
            // 구독 안에 있는 코드는 저장만 시키고 message가 전달되면 실행
            console.log('📩 관리자 메시지 받음:', message.body);  // ⭐ 추가
            // 메시지 오면 toast라이브러리 실행
            toast.info(`🔔 새 문의: ${message.body}`, {
              icon: '📩',  // 아이콘 커스텀
              onClick: () => {nav('/admin/qna')}
            });

            // app의 handleNoti 실행
            if(onNotification){
              console.log('onNotification 실행');  // ⭐ 추가
              onNotification(true); // isAdmin = true 전달
            } else {
              console.log('onNotification이 없음!');  // ⭐
            }
          });

        } 
        // 일반 사용자면
        else if (userId) {
          // '/topic/user/사용자ID' 주소 구독 (개인 알림용)
          client.subscribe(`/topic/user/${userId}`, (message) => {
            // 메시지 오면 toast 라이브러리 실행
            toast.success(`✅ 새 답변: ${message.body}`, {
              icon: '💬',  // 아이콘 커스텀
              onClick: () => {nav('/user/info')}
            });

            // app의 handleNoti 실행
            if(onNotification){
              onNotification(false); // isAdmin = false 전달
            };
          });
        }
      },
      
      // WebSocket 에러 발생 시 실행
      onStompError: (frame) => {
        console.error('WebSocket 에러:', frame);
      },
    });

    // WebSocket 연결 시작
    client.activate();
    
    // ref에 저장 (다른 곳에서 사용 가능하도록)
    clientRef.current = client;

    // cleanup: 컴포넌트 언마운트 or userId/isAdmin 변경 시 실행
    // 없으면 로그아웃 해도 socket연결이 안 끊겨 중복 연결됨
    return () => {
      clientRef.current?.deactivate();  // ✅ WebSocket 연결 종료
    };
  }, [userId, isAdmin, onNotification, nav]);  // 이 값들이 바뀌면 useEffect 재실행

};