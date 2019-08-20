package com.ryg.chapter_2.demo4.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetailsBean {

    /**
     * rating : {"max":10,"average":6.7,"details":{"1":103,"3":4621,"2":899,"5":833,"4":2605},"stars":"35","min":0}
     * reviews_count : 173
     * videos : [{"source":{"literal":"qq","pic":"https://img3.doubanio.com/f/movie/0a74f4379607fa731489d7f34daa545df9481fa0/pics/movie/video-qq.png","name":"腾讯视频"},"sample_link":"http://v.qq.com/x/cover/v32nwd2khrrupi7.html?ptag=douban.movie","video_id":"v32nwd2khrrupi7","need_pay":true},{"source":{"literal":"youku","pic":"https://img1.doubanio.com/f/movie/886b26a83d18bc60de4ee1daac38145f03c88792/pics/movie/video-youku.png","name":"优酷视频"},"sample_link":"http://v.youku.com/v_show/id_XNDI3MDUxODcyOA==.html?tpa=dW5pb25faWQ9MzAwMDA4XzEwMDAwMl8wMl8wMQ&refer=esfhz_operation.xuka.xj_00003036_000000_FNZfau_19010900","video_id":"XNDI3MDUxODcyOA==","need_pay":true},{"source":{"literal":"iqiyi","pic":"https://img3.doubanio.com/f/movie/7c9e516e02c6fe445b6559c0dd2a705e8b17d1c9/pics/movie/video-iqiyi.png","name":"爱奇艺视频"},"sample_link":"http://www.iqiyi.com/v_19rqt1v4dc.html?vfm=m_331_dbdy&fv=4904d94982104144a1548dd9040df241","video_id":"19rqt1v4dc","need_pay":true},{"source":{"literal":"sohu","pic":"https://img1.doubanio.com/f/movie/77358cffb08eb6750a0880136f0575c9e7e9a749/pics/movie/video-sohu.png","name":"搜狐视频"},"sample_link":"http://film.sohu.com/album/9555103.html","video_id":"5556860","need_pay":true}]
     * wish_count : 27996
     * original_title : Dumbo
     * blooper_urls : ["http://vt1.doubanio.com/201908201450/c4f87862f7e91cf3edaacf5cabea1c5d/view/movie/M/302450784.mp4","http://vt1.doubanio.com/201908201450/8ad6940f9a7ac9997b49f5426ef422dc/view/movie/M/302440281.mp4","http://vt1.doubanio.com/201908201450/75fd470b74163922ff70537c04880b65/view/movie/M/302430918.mp4","http://vt1.doubanio.com/201908201450/23fa865a04844cdb9e0f2a862b430cdb/view/movie/M/302440574.mp4"]
     * collect_count : 48873
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp"}
     * douban_site :
     * year : 2019
     * popular_comments : [{"rating":{"max":5,"value":4,"min":0},"useful_count":36,"author":{"uid":"amor27","avatar":"https://img1.doubanio.com/icon/u2432492-8.jpg","signature":"或我应该相信是缘分","alt":"https://www.douban.com/people/amor27/","id":"2432492","name":"amor27"},"subject_id":"25924056","content":"真人版的《小飞象》依旧那么温暖而充满魔力，小飞象每一次的腾空飞起，都足以点亮心中一点点的奇梦。虽然跟爱丽丝梦游仙境比起来，这部电影Tim Burton的色彩没有那么浓厚，可以算作大鱼的合家欢版本，但导演代表性的绚丽色彩和童心跟迪士尼结合起来还是相得益彰，更何况，比动画版更萌的小飞象，谁能抗拒呢。\n","created_at":"2019-03-19 23:58:03","id":"1722431381"},{"rating":{"max":5,"value":0,"min":0},"useful_count":0,"author":{"uid":"taiyanyinke1984","avatar":"https://img3.doubanio.com/icon/u1924404-12.jpg","signature":"","alt":"https://www.douban.com/people/taiyanyinke1984/","id":"1924404","name":"大炎"},"subject_id":"25924056","content":"迪士尼没完没了的平庸翻拍\u2026真·行业罪人\u2026","created_at":"2019-07-14 23:46:51","id":"902017509"},{"rating":{"max":5,"value":4,"min":0},"useful_count":132,"author":{"uid":"49867478","avatar":"https://img3.doubanio.com/icon/u49867478-2.jpg","signature":"生命没有黑暗，灵魂没有假肢","alt":"https://www.douban.com/people/49867478/","id":"49867478","name":"我爱罗宾"},"subject_id":"25924056","content":"当姐弟俩得知象妈妈要被杀掉，姐姐伤心跑开。弟弟留在原地等待爱娃·格林洗面奶，之后又解锁了爱娃的膝枕，最后还坐上变成小直升机的小飞象...我🍋了","created_at":"2019-03-29 12:23:03","id":"1732984874"},{"rating":{"max":5,"value":2,"min":0},"useful_count":197,"author":{"uid":"lingrui1995","avatar":"https://img1.doubanio.com/icon/u63688511-18.jpg","signature":"一个影迷","alt":"https://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿"},"subject_id":"25924056","content":"作为一部拍给儿童看的电影，拍得太无趣了。大人觉得幼稚，小孩也觉得枯燥。\n表面上没什么问题，其实没有问题就是最大的问题，因为拍得太工整了，四平八稳，所以也没有任何亮点。\n这种中规中矩，走安全路线，追求稳而不愿意有所创新的电影根本就不应该被拍出来。\n自从蒂姆\u2022波顿去迪士尼拍合家欢电影后就越来越保守和胆怯，当年拍《剪刀手爱德华》《大鱼》的大胆、灵气、魅力、创新、想象力已经荡然无存。\n不得不说迪士尼真是毒瘤，太不思进取了，巴不得把所有动画电影全部拍成真人版，巴不得给所有电影都拍续集，永远吃老本，没有丝毫创新精神，结果票房还那么高，搞得现在所有电影公司都纷纷效仿，不断翻拍、拍续集、压榨IP、打造电影宇宙\u2026\u2026根本没人去拍原创内容了。","created_at":"2019-03-29 21:30:39","id":"1733506781"}]
     * alt : https://movie.douban.com/subject/25924056/
     * id : 25924056
     * mobile_url : https://movie.douban.com/subject/25924056/mobile
     * photos_count : 248
     * pubdate : 2019-03-29
     * title : 小飞象
     * do_count : null
     * has_video : true
     * share_url : https://m.douban.com/movie/subject/25924056
     * seasons_count : null
     * languages : ["英语"]
     * schedule_url :
     * writers : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp"},"name_en":"Ehren Kruger","name":"伊伦·克鲁格","alt":"https://movie.douban.com/celebrity/1027468/","id":"1027468"}]
     * pubdates : ["2019-03-29(美国)","2019-03-29(中国大陆)"]
     * website :
     * tags : ["迪士尼","童话","奇幻","温情","美国","真人版","动画","2019","动物","成长"]
     * has_schedule : false
     * durations : ["112分钟"]
     * genres : ["奇幻","冒险"]
     * collection : null
     * trailers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2549236313.jpg?","title":"中国预告片：定档版 (中文字幕)","subject_id":"25924056","alt":"https://movie.douban.com/trailer/243680/","small":"https://img3.doubanio.com/img/trailer/small/2549236313.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/c346efa57347b7b230e768e53ebee381/view/movie/M/302430680.mp4","id":"243680"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2548233183.jpg?","title":"预告片","subject_id":"25924056","alt":"https://movie.douban.com/trailer/243330/","small":"https://img3.doubanio.com/img/trailer/small/2548233183.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/246723353f7c9cf975c0ac33a5e20089/view/movie/M/302430330.mp4","id":"243330"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2547776058.jpg?","title":"预告片","subject_id":"25924056","alt":"https://movie.douban.com/trailer/243048/","small":"https://img1.doubanio.com/img/trailer/small/2547776058.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/981af685165ffae6bb7bb19a657f22b0/view/movie/M/302430048.mp4","id":"243048"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2547323840.jpg?","title":"预告片","subject_id":"25924056","alt":"https://movie.douban.com/trailer/242948/","small":"https://img3.doubanio.com/img/trailer/small/2547323840.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/934c97209c57c729f4a2db621bdd2d49/view/movie/M/302420948.mp4","id":"242948"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201908201450/c346efa57347b7b230e768e53ebee381/view/movie/M/302430680.mp4","http://vt1.doubanio.com/201908201450/246723353f7c9cf975c0ac33a5e20089/view/movie/M/302430330.mp4","http://vt1.doubanio.com/201908201450/981af685165ffae6bb7bb19a657f22b0/view/movie/M/302430048.mp4","http://vt1.doubanio.com/201908201450/934c97209c57c729f4a2db621bdd2d49/view/movie/M/302420948.mp4"]
     * has_ticket : false
     * bloopers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2553589753.jpg?","title":"花絮","subject_id":"25924056","alt":"https://movie.douban.com/trailer/245784/","small":"https://img3.doubanio.com/img/trailer/small/2553589753.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/c4f87862f7e91cf3edaacf5cabea1c5d/view/movie/M/302450784.mp4","id":"245784"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2550518084.jpg?","title":"花絮","subject_id":"25924056","alt":"https://movie.douban.com/trailer/244281/","small":"https://img3.doubanio.com/img/trailer/small/2550518084.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/8ad6940f9a7ac9997b49f5426ef422dc/view/movie/M/302440281.mp4","id":"244281"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2549594781.jpg?","title":"花絮","subject_id":"25924056","alt":"https://movie.douban.com/trailer/243918/","small":"https://img3.doubanio.com/img/trailer/small/2549594781.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/75fd470b74163922ff70537c04880b65/view/movie/M/302430918.mp4","id":"243918"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2551079599.jpg?","title":"MV：中文主题曲《亲爱的》  (中文字幕)","subject_id":"25924056","alt":"https://movie.douban.com/trailer/244574/","small":"https://img1.doubanio.com/img/trailer/small/2551079599.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/23fa865a04844cdb9e0f2a862b430cdb/view/movie/M/302440574.mp4","id":"244574"}]
     * clip_urls : ["http://vt1.doubanio.com/201908201450/2fd29636bbdc856e045c73bf7a5e9ad6/view/movie/M/302450293.mp4","http://vt1.doubanio.com/201908201450/bbd3d349d044469e70caaabbe2f909fe/view/movie/M/302450060.mp4","http://vt1.doubanio.com/201908201450/1c4fdca3f7bac75e174dd9ef2e49c0d1/view/movie/M/302440861.mp4","http://vt1.doubanio.com/201908201450/b74487198c5b77c99e6a4f4abf1e2de7/view/movie/M/302440545.mp4"]
     * current_season : null
     * casts : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp"},"name_en":"Eva Green","name":"伊娃·格林","alt":"https://movie.douban.com/celebrity/1025155/","id":"1025155"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p724.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p724.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p724.webp"},"name_en":"Colin Farrell","name":"科林·法瑞尔","alt":"https://movie.douban.com/celebrity/1084255/","id":"1084255"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1420615848.64.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1420615848.64.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1420615848.64.webp"},"name_en":"Michael Keaton","name":"迈克尔·基顿","alt":"https://movie.douban.com/celebrity/1049486/","id":"1049486"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1553671478.35.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1553671478.35.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1553671478.35.webp"},"name_en":"Nico Parker","name":"妮可·帕克","alt":"https://movie.douban.com/celebrity/1405391/","id":"1405391"}]
     * countries : ["美国"]
     * mainland_pubdate : 2019-03-29
     * photos : [{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2550554424.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2550554424.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2550554424.webp","alt":"https://movie.douban.com/photos/photo/2550554424/","id":"2550554424","icon":"https://img3.doubanio.com/view/photo/s/public/p2550554424.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2551978827.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2551978827.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2551978827.webp","alt":"https://movie.douban.com/photos/photo/2551978827/","id":"2551978827","icon":"https://img1.doubanio.com/view/photo/s/public/p2551978827.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2546099431.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2546099431.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2546099431.webp","alt":"https://movie.douban.com/photos/photo/2546099431/","id":"2546099431","icon":"https://img3.doubanio.com/view/photo/s/public/p2546099431.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2534700049.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2534700049.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2534700049.webp","alt":"https://movie.douban.com/photos/photo/2534700049/","id":"2534700049","icon":"https://img1.doubanio.com/view/photo/s/public/p2534700049.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2524974068.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2524974068.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2524974068.webp","alt":"https://movie.douban.com/photos/photo/2524974068/","id":"2524974068","icon":"https://img1.doubanio.com/view/photo/s/public/p2524974068.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2562811525.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2562811525.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2562811525.webp","alt":"https://movie.douban.com/photos/photo/2562811525/","id":"2562811525","icon":"https://img3.doubanio.com/view/photo/s/public/p2562811525.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2562811524.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2562811524.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2562811524.webp","alt":"https://movie.douban.com/photos/photo/2562811524/","id":"2562811524","icon":"https://img3.doubanio.com/view/photo/s/public/p2562811524.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2562811521.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2562811521.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2562811521.webp","alt":"https://movie.douban.com/photos/photo/2562811521/","id":"2562811521","icon":"https://img3.doubanio.com/view/photo/s/public/p2562811521.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2562811520.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2562811520.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2562811520.webp","alt":"https://movie.douban.com/photos/photo/2562811520/","id":"2562811520","icon":"https://img3.doubanio.com/view/photo/s/public/p2562811520.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2562811519.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2562811519.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2562811519.webp","alt":"https://movie.douban.com/photos/photo/2562811519/","id":"2562811519","icon":"https://img1.doubanio.com/view/photo/s/public/p2562811519.webp"}]
     * summary : 迪士尼全新真人版《小飞象》改编自1941年推出的迪士尼同名经典动画，讲述了生来因一双大耳朵而遭人嘲笑的小飞象，在众人的帮助下逐渐拥抱自己的与众不同，成就一段逆风翱翔的暖心传奇。
     一位前马戏团明星，刚从战争前线归来，霍特·法瑞尔(科林·法瑞尔饰)在一家艰难经营的马戏团谋得一份工作，负责照顾刚出生的小象，带着两个善良的孩子，女儿米莉·法瑞尔(尼科·帕克饰)和儿子乔·法瑞尔(芬利·霍宾斯饰)，两个孩子和另外一个女孩玛茜特(蔡慧泉饰)与小飞象成为朋友， 帮助小飞象找到妈妈。
     当人们发现小象会飞后，马戏团重复生机，更吸引到一个充满心机的生意人文德维尔（迈克尔·基顿饰）的注意，他把小飞象雇佣到他的大型游乐场Dreamland，与杂技演员柯莱特·马钱特(伊娃·格林饰)做搭档，人气达到新高度，然而霍特·法瑞尔发现，游乐场光鲜亮丽的背后，充满种种见不得人的秘密。
     * clips : [{"medium":"https://img1.doubanio.com/img/trailer/medium/2552514207.jpg?","title":"片段","subject_id":"25924056","alt":"https://movie.douban.com/trailer/245293/","small":"https://img1.doubanio.com/img/trailer/small/2552514207.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/2fd29636bbdc856e045c73bf7a5e9ad6/view/movie/M/302450293.mp4","id":"245293"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2552037547.jpg?","title":"片段","subject_id":"25924056","alt":"https://movie.douban.com/trailer/245060/","small":"https://img1.doubanio.com/img/trailer/small/2552037547.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/bbd3d349d044469e70caaabbe2f909fe/view/movie/M/302450060.mp4","id":"245060"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2551636563.jpg?","title":"片段","subject_id":"25924056","alt":"https://movie.douban.com/trailer/244861/","small":"https://img3.doubanio.com/img/trailer/small/2551636563.jpg?","resource_url":"http://vt1.doubanio.com/201908201450/1c4fdca3f7bac75e174dd9ef2e49c0d1/view/movie/M/302440861.mp4","id":"244861"},{"medium":"https://img1.doubanio.com/view/photo/photo/public/p2550877399.webp","title":"片段","subject_id":"25924056","alt":"https://movie.douban.com/trailer/244545/","small":"https://img1.doubanio.com/view/photo/photo/public/p2550877399.webp","resource_url":"http://vt1.doubanio.com/201908201450/b74487198c5b77c99e6a4f4abf1e2de7/view/movie/M/302440545.mp4","id":"244545"}]
     * subtype : movie
     * directors : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp"},"name_en":"Tim Burton","name":"蒂姆·波顿","alt":"https://movie.douban.com/celebrity/1019002/","id":"1019002"}]
     * comments_count : 13877
     * popular_reviews : [{"rating":{"max":5,"value":4,"min":0},"title":"彩蛋分析，对比41动画版中的一些细节","subject_id":"25924056","author":{"uid":"129169745","avatar":"https://img3.doubanio.com/icon/u129169745-3.jpg","signature":"","alt":"https://www.douban.com/people/129169745/","id":"129169745","name":"VictorZou"},"summary":"迪迷的彩蛋考据向影评，主要针对这部电影和40版《小飞象》中的相同与不同的几个细节。 今天中午1点开始看，学校里的电影院结果被我包场了，看来大家都是因为昨天才听到4.24妇联4上映，注意力没有在《小飞象》真人...","alt":"https://movie.douban.com/review/10075733/","id":"10075733"},{"rating":{"max":5,"value":4,"min":0},"title":"这从来就不是一个拥抱自我的鸡汤故事","subject_id":"25924056","author":{"uid":"4786986","avatar":"https://img3.doubanio.com/icon/u4786986-11.jpg","signature":"爱电影的小兄弟","alt":"https://www.douban.com/people/4786986/","id":"4786986","name":"xiaoxiongdi"},"summary":"蒂姆波顿用一部颠覆原版的电影向所有人宣示了自由的重要性。跟我预想的一样，蒂姆波顿的版本拥有了奥德赛的味道，小飞象逃离了马戏团，回归象群，重返大自然。 自由从来就不是人类的专利。当那些老奸巨猾的商人熟...","alt":"https://movie.douban.com/review/10076121/","id":"10076121"},{"rating":{"max":5,"value":0,"min":0},"title":"创业是 996 的出路吗？一场经典童话中的裁员纠纷","subject_id":"25924056","author":{"uid":"stscar","avatar":"https://img3.doubanio.com/icon/u53336808-163.jpg","signature":"想平静生活的上班族","alt":"https://www.douban.com/people/stscar/","id":"53336808","name":"柴斯卡"},"summary":"原载于豆瓣阅读官方微信号：https://mp.weixin.qq.com/s/PQIz7rZXLxDvYzd9GsLUvg 欢迎关注~ 1. 小工人，大企业 初看 2019 年的真人版《小飞象》，可能会以为它是一部与蒂姆·波顿的其他作品（《剪刀手爱德华》、...","alt":"https://movie.douban.com/review/10120739/","id":"10120739"},{"rating":{"max":5,"value":4,"min":0},"title":"大反派文德维尔悲剧的来源","subject_id":"25924056","author":{"uid":"194215794","avatar":"https://img3.doubanio.com/icon/u194215794-1.jpg","signature":"","alt":"https://www.douban.com/people/194215794/","id":"194215794","name":"起风了"},"summary":"谈谈最新上映的电影《小飞象》。故事的主线讲的是一只长相特别的小象，经历各种惊险，找到自己，寻回母亲，最后重回大自然的故事。 但我更有兴趣探讨一下，其中作为大反派出现的商人\u2014\u2014文德维尔。 文德维尔第一...","alt":"https://movie.douban.com/review/10078751/","id":"10078751"},{"rating":{"max":5,"value":4,"min":0},"title":"包容不完美，欣赏不完美，没有所谓的完美，也没有所谓的残缺，只有美好的特殊之处，每个人都有自己的价值。","subject_id":"25924056","author":{"uid":"171661529","avatar":"https://img3.doubanio.com/icon/u171661529-2.jpg","signature":"","alt":"https://www.douban.com/people/171661529/","id":"171661529","name":"已注销"},"summary":"小飞象拍真人版，一听特别感慨，动物真人化很难，但这部电影融合得很好。我是TimBurton的老影迷，看的第一部他电影是在90年代前半段，爸爸买来的蝙蝠侠和剪刀手爱德华录像带，现在漫改英雄电影大行其道，得托30年...","alt":"https://movie.douban.com/review/10075494/","id":"10075494"},{"rating":{"max":5,"value":2,"min":0},"title":"对不起，这次我不买迪士尼的账","subject_id":"25924056","author":{"uid":"160866646","avatar":"https://img3.doubanio.com/icon/u160866646-2.jpg","signature":"","alt":"https://www.douban.com/people/160866646/","id":"160866646","name":"烧饭"},"summary":"大概是我近几年看过最没有诚意的迪士尼电影了吧。说说以下几点原因。（本文带有强剧透） 1 演技太尬。两个小孩全程在棒读，一开始在火车站找爸爸可以看得出他们对老爸还是有感情的。可是看到他的断臂之后突然就成...","alt":"https://movie.douban.com/review/10078743/","id":"10078743"},{"rating":{"max":5,"value":4,"min":0},"title":"小飞象的线索\u2014\u2014残缺","subject_id":"25924056","author":{"uid":"180016015","avatar":"https://img3.doubanio.com/icon/u180016015-2.jpg","signature":"","alt":"https://www.douban.com/people/180016015/","id":"180016015","name":"嘉木"},"summary":"最先让我想起的是小学时候的一篇课文《曼谷的小象》，关于《小飞象》没有太多的了解过它的历史前缘。觉着抱着\u201c逢时遇景，拾翠寻芳\u201d的心态来看就蛮好的。 一、残缺。 导演用人物、角色（笨宝）、情感的残缺在编...","alt":"https://movie.douban.com/review/10076062/","id":"10076062"},{"rating":{"max":5,"value":2,"min":0},"title":"为什么是波顿？","subject_id":"25924056","author":{"uid":"192724807","avatar":"https://img3.doubanio.com/icon/u192724807-1.jpg","signature":"","alt":"https://www.douban.com/people/192724807/","id":"192724807","name":"Marlin"},"summary":"我特别想知道，为什么会有人选择蒂姆·波顿来改编一部温情美好、天然无害的儿童电影？ 蒂姆·波顿作为好莱坞一位具有强烈个人风格的鬼才导演，他对电影有着一种独特的天赋：创造怪异、诡谲并且令人毛骨悚然的视觉...","alt":"https://movie.douban.com/review/10076453/","id":"10076453"},{"rating":{"max":5,"value":4,"min":0},"title":"没有那片羽毛，你也一样可以自己飞翔","subject_id":"25924056","author":{"uid":"39690610","avatar":"https://img3.doubanio.com/icon/u39690610-4.jpg","signature":"知君只爱市中隐，把酒问花坐相悦","alt":"https://www.douban.com/people/39690610/","id":"39690610","name":"瑞波恩"},"summary":"才忽然意识到，蒂姆\u2022伯顿如今也已经60多岁，可以叫他老蒂姆了。不知道该为他开心还是难过，反正他的电影是越来越充满童心了，比如这部《小飞象》。这可能是《查理和巧克力工厂》之后，我看过的老蒂姆最有童年...","alt":"https://movie.douban.com/review/10090497/","id":"10090497"},{"rating":{"max":5,"value":3,"min":0},"title":"小飞象","subject_id":"25924056","author":{"uid":"185087806","avatar":"https://img3.doubanio.com/icon/u185087806-3.jpg","signature":"","alt":"https://www.douban.com/people/185087806/","id":"185087806","name":"周周"},"summary":"就是小象和妈妈分开之后，特别难过，小男儿说也许他只是想自己静一静 小女孩马上反驳说，\u201c nobody wants to be alone\u201d 这个我一瞬间就泪目了。 想到自己中学的时候，明明也没有做错什么，就只不过因为自己家庭...","alt":"https://movie.douban.com/review/10082675/","id":"10082675"}]
     * ratings_count : 39273
     * aka : ["小飞象真人版"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<VideosBean> videos;
    private List<String> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<BloopersBean> bloopers;
    private List<String> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<ClipsBean> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public List<String> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<String> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<BloopersBean> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<BloopersBean> bloopers) {
        this.bloopers = bloopers;
    }

    public List<String> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<String> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<ClipsBean> getClips() {
        return clips;
    }

    public void setClips(List<ClipsBean> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 6.7
         * details : {"1":103,"3":4621,"2":899,"5":833,"4":2605}
         * stars : 35
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 103.0
             * 3 : 4621.0
             * 2 : 899.0
             * 5 : 833.0
             * 4 : 2605.0
             */

            @SerializedName("1")
            private double _$1;
            @SerializedName("3")
            private double _$3;
            @SerializedName("2")
            private double _$2;
            @SerializedName("5")
            private double _$5;
            @SerializedName("4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class VideosBean {
        /**
         * source : {"literal":"qq","pic":"https://img3.doubanio.com/f/movie/0a74f4379607fa731489d7f34daa545df9481fa0/pics/movie/video-qq.png","name":"腾讯视频"}
         * sample_link : http://v.qq.com/x/cover/v32nwd2khrrupi7.html?ptag=douban.movie
         * video_id : v32nwd2khrrupi7
         * need_pay : true
         */

        private SourceBean source;
        private String sample_link;
        private String video_id;
        private boolean need_pay;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getSample_link() {
            return sample_link;
        }

        public void setSample_link(String sample_link) {
            this.sample_link = sample_link;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public boolean isNeed_pay() {
            return need_pay;
        }

        public void setNeed_pay(boolean need_pay) {
            this.need_pay = need_pay;
        }

        public static class SourceBean {
            /**
             * literal : qq
             * pic : https://img3.doubanio.com/f/movie/0a74f4379607fa731489d7f34daa545df9481fa0/pics/movie/video-qq.png
             * name : 腾讯视频
             */

            private String literal;
            private String pic;
            private String name;

            public String getLiteral() {
                return literal;
            }

            public void setLiteral(String literal) {
                this.literal = literal;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":4,"min":0}
         * useful_count : 36
         * author : {"uid":"amor27","avatar":"https://img1.doubanio.com/icon/u2432492-8.jpg","signature":"或我应该相信是缘分","alt":"https://www.douban.com/people/amor27/","id":"2432492","name":"amor27"}
         * subject_id : 25924056
         * content : 真人版的《小飞象》依旧那么温暖而充满魔力，小飞象每一次的腾空飞起，都足以点亮心中一点点的奇梦。虽然跟爱丽丝梦游仙境比起来，这部电影Tim Burton的色彩没有那么浓厚，可以算作大鱼的合家欢版本，但导演代表性的绚丽色彩和童心跟迪士尼结合起来还是相得益彰，更何况，比动画版更萌的小飞象，谁能抗拒呢。
         * created_at : 2019-03-19 23:58:03
         * id : 1722431381
         */

        private RatingBeanX rating;
        private int useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5
             * value : 4.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : amor27
             * avatar : https://img1.doubanio.com/icon/u2432492-8.jpg
             * signature : 或我应该相信是缘分
             * alt : https://www.douban.com/people/amor27/
             * id : 2432492
             * name : amor27
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp"}
         * name_en : Ehren Kruger
         * name : 伊伦·克鲁格
         * alt : https://movie.douban.com/celebrity/1027468/
         * id : 1027468
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25844.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class TrailersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2549236313.jpg?
         * title : 中国预告片：定档版 (中文字幕)
         * subject_id : 25924056
         * alt : https://movie.douban.com/trailer/243680/
         * small : https://img3.doubanio.com/img/trailer/small/2549236313.jpg?
         * resource_url : http://vt1.doubanio.com/201908201450/c346efa57347b7b230e768e53ebee381/view/movie/M/302430680.mp4
         * id : 243680
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class BloopersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2553589753.jpg?
         * title : 花絮
         * subject_id : 25924056
         * alt : https://movie.douban.com/trailer/245784/
         * small : https://img3.doubanio.com/img/trailer/small/2553589753.jpg?
         * resource_url : http://vt1.doubanio.com/201908201450/c4f87862f7e91cf3edaacf5cabea1c5d/view/movie/M/302450784.mp4
         * id : 245784
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp"}
         * name_en : Eva Green
         * name : 伊娃·格林
         * alt : https://movie.douban.com/celebrity/1025155/
         * id : 1025155
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25343.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PhotosBean {
        /**
         * thumb : https://img3.doubanio.com/view/photo/m/public/p2550554424.webp
         * image : https://img3.doubanio.com/view/photo/l/public/p2550554424.webp
         * cover : https://img3.doubanio.com/view/photo/sqs/public/p2550554424.webp
         * alt : https://movie.douban.com/photos/photo/2550554424/
         * id : 2550554424
         * icon : https://img3.doubanio.com/view/photo/s/public/p2550554424.webp
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class ClipsBean {
        /**
         * medium : https://img1.doubanio.com/img/trailer/medium/2552514207.jpg?
         * title : 片段
         * subject_id : 25924056
         * alt : https://movie.douban.com/trailer/245293/
         * small : https://img1.doubanio.com/img/trailer/small/2552514207.jpg?
         * resource_url : http://vt1.doubanio.com/201908201450/2fd29636bbdc856e045c73bf7a5e9ad6/view/movie/M/302450293.mp4
         * id : 245293
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp"}
         * name_en : Tim Burton
         * name : 蒂姆·波顿
         * alt : https://movie.douban.com/celebrity/1019002/
         * id : 1019002
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanXX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44690.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":4,"min":0}
         * title : 彩蛋分析，对比41动画版中的一些细节
         * subject_id : 25924056
         * author : {"uid":"129169745","avatar":"https://img3.doubanio.com/icon/u129169745-3.jpg","signature":"","alt":"https://www.douban.com/people/129169745/","id":"129169745","name":"VictorZou"}
         * summary : 迪迷的彩蛋考据向影评，主要针对这部电影和40版《小飞象》中的相同与不同的几个细节。 今天中午1点开始看，学校里的电影院结果被我包场了，看来大家都是因为昨天才听到4.24妇联4上映，注意力没有在《小飞象》真人...
         * alt : https://movie.douban.com/review/10075733/
         * id : 10075733
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanXX {
            /**
             * max : 5
             * value : 4.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : 129169745
             * avatar : https://img3.doubanio.com/icon/u129169745-3.jpg
             * signature :
             * alt : https://www.douban.com/people/129169745/
             * id : 129169745
             * name : VictorZou
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
